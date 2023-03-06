package com.management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.management.dao.PartMapper;
import com.management.domain.Code;
import com.management.domain.Part;
import com.management.domain.Result;
import com.management.service.PartService;
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
 * 零件表 服务实现类
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-16
 */
@Service
public class PartServiceImpl extends ServiceImpl<PartMapper, Part> implements PartService {
    @Autowired
    private PartMapper partMapper;

    @Value("${spring.servlet.multipart.location}" + "/part/")
    private String uploadRootPath;

    @Override
    public Result<Boolean> insertPart(Part part, MultipartFile file) {
        if (file != null) {
            String orgName = file.getOriginalFilename();
            String extName = orgName.substring(orgName.lastIndexOf('.'));
            String destName = UUID.randomUUID().toString().toUpperCase() + extName;
            try {
                file.transferTo(new File(uploadRootPath, destName));
                part.setPartPicPath("/part/" + destName);
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
                return new Result<Boolean>(false, Code.Part_Insert_Failure, "插入失败");
            }
        }
        if (partMapper.insert(part) != 0) return new Result(true, Code.Part_Insert_Success, "零件添加成功");
        else return new Result<>(false, Code.Part_Insert_Failure, "零件添加失败");
    }

    @Override
    public Result<List<Part>> selectParts(Part part) {
        List list = partMapper.selectParts(part);
        if(!list.isEmpty()) return  new Result<>(list,Code.Select_Success,"选择成功");
        else return new Result(false,Code.Select_Null,"查询为空");
    }

    @Override
    public Boolean updatePart(Part part) {
        if(partMapper.updateById(part) != 0 ) return true;
        else return false;
    }
}
