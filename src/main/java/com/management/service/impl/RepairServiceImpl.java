package com.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.management.dao.DeviceMapper;
import com.management.dao.MemberMapper;
import com.management.dao.RepairMapper;
import com.management.dao.RepairPicMapper;
import com.management.domain.*;
import com.management.service.RepairService;
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
 * 维修表 服务实现类
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-19
 */
@Service
public class RepairServiceImpl extends ServiceImpl<RepairMapper, Repair> implements RepairService {
    @Autowired
    private RepairMapper repairMapper;
    @Autowired
    private RepairPicMapper repairPicMapper;
    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private MemberMapper memberMapper;

    @Value("${spring.servlet.multipart.location}" + "/repair/")
    private String uploadRootPath;

    @Override
    public Result<Boolean> insertRepairTask(Repair repair, List<MultipartFile> files) {
        if (repairMapper.insert(repair) != 0) {
            Integer id = repair.getRepairDeviceId();
            Device device = new Device();
            device.setDeviceId(id);
            device.setDeviceStatus(2);
            deviceMapper.updateById(device);
            for (MultipartFile file : files) {
                String orgName = file.getOriginalFilename();
                String extName = orgName.substring(orgName.lastIndexOf('.'));
                String destName = UUID.randomUUID().toString().toUpperCase() + extName;
                try {
                    file.transferTo(new File(uploadRootPath, destName));
                } catch (IllegalStateException | IOException e) {
                    e.printStackTrace();
                    return new Result<Boolean>(false, Code.Insert_Failure, "日志图片上传失败");
                }
                RepairPic repairPic = new RepairPic();
                repairPic.setRepairPicPath("/repair/"+destName);
                repairPic.setRepairId(repair.getRepairId());
                if(repairPicMapper.insert(repairPic) == 0) return  new Result<Boolean>(false,Code.Insert_Failure,"日志图片上传失败");
            }
            return new Result<Boolean>(true,Code.Insert_Success,"上传成功");
        }
        else return new Result<Boolean>(false,Code.Insert_Failure,"日志生成失败");
    }

    @Override
    public Result<List<RepairDetail>> selectRepairs(RepairDetail repair, String startTime, String endTime,Boolean type) {
        List<RepairDetail> list = repairMapper.selectRepairs(repair, startTime, endTime, type);
        System.out.println(list);
        System.out.println(list);
        for (RepairDetail item : list) {
            List picList = repairPicMapper.selectList(new LambdaQueryWrapper<RepairPic>().eq(RepairPic::getRepairId, item.getRepairId()));
            item.setRepairPicList(picList);
        }
        if (list.isEmpty()) {
            return new Result(false, Code.Select_Null, "查询失败");
        } else return new Result<>(list, Code.Select_Success, "查询成功");
    }

    @Override
    public Result<Boolean> updateRepair(Repair repair) {
        if (repairMapper.updateById(repair) != 0) {
            Member member = new Member();
            member.setMemberId(repair.getRepairMemberId());
            member.setMemberStatus(1);
            memberMapper.updateById(member);
            return new Result<>(true, Code.Update_Success, "工单状态更新完成");
        } else return new Result<>(false, Code.Update_Failure, "工单状态更新失败");
    }
}
