package com.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.management.dao.MaintainPicMapper;
import com.management.domain.*;
import com.management.dao.MaintainMapper;
import com.management.service.MaintainService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 保养表 服务实现类
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-19
 */
@Service
public class MaintainServiceImpl extends ServiceImpl<MaintainMapper, Maintain> implements MaintainService {
    @Autowired
    private MaintainMapper maintainMapper;
    @Autowired
    private MaintainPicMapper maintainPicMapper;

    @Value("${spring.servlet.multipart.location}" + "/maintain/")
    private String uploadRootPath;

    @Override
    public Result<Boolean> insertMaintainLog(Maintain maintain, MultipartFile[] files) {
        if(maintainMapper.insert(maintain) != 0){
            for(MultipartFile file: files){
                String orgName = file.getOriginalFilename();
                String extName = orgName.substring(orgName.lastIndexOf('.'));
                String destName = UUID.randomUUID().toString().toUpperCase() + extName;
                try{
                    file.transferTo(new File(uploadRootPath,destName));
                }catch (IllegalStateException | IOException e){
                    e.printStackTrace();
                    return new Result<Boolean>(false,Code.Insert_Failure,"日志图片上传失败");
                }
                MaintainPic maintainPic = new MaintainPic();
                maintainPic.setMaintainPicPath("/maintain/"+destName);
                maintainPic.setMaintainId(maintain.getMaintainId());
                if(maintainPicMapper.insert(maintainPic) == 0) return  new Result<Boolean>(false,Code.Insert_Failure,"日志图片上传失败");
            }
            return new Result<Boolean>(true,Code.Insert_Success,"上传成功");
        }
        else return new Result<Boolean>(false,Code.Insert_Failure,"日志生成失败");
    }

    @Override
    public Result<List<Maintain>> selectMaintainLogs(Maintain maintain,String  startTime, String endTime) {
        List<Maintain> list = maintainMapper.selectMaintainLogs(maintain,startTime,endTime);
        if(list.isEmpty()) return new Result(false,Code.Select_Null,"查询为空");
        else return new Result<List<Maintain>>(list,Code.Select_Success,"查询成功");
    }

    @Override
    public Result<MaintainDetail> selectMaintaindetails(Integer maintainId) {
        MaintainDetail maintainDetail = maintainMapper.selectMaintainDetails(maintainId);
        maintainDetail.setMaintainPicList(maintainPicMapper.selectList(new LambdaQueryWrapper<MaintainPic>().eq(MaintainPic::getMaintainId,maintainId)));
        if(maintainDetail != null) return new Result<MaintainDetail>(maintainDetail,Code.Select_Success,"查询成功");
        else return new Result(false,Code.Select_Null,"查询为空");
    }

}
