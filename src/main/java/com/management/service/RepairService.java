package com.management.service;

import com.management.domain.Repair;
import com.baomidou.mybatisplus.extension.service.IService;
import com.management.domain.RepairDetail;
import com.management.domain.Result;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 维修表 服务类
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-19
 */
public interface RepairService extends IService<Repair> {
    /**
     * 生成维修任务
     * @param repair
     * @return
     */
    public Result<Boolean> insertRepairTask(Repair repair, MultipartFile[] files);
    /**
     * 查询维修任务
     */
    public Result<List<RepairDetail>> selectRepairs(RepairDetail repair,String startTime,String endTime,Boolean type);


}
