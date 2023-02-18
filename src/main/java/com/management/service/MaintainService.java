package com.management.service;

import com.management.domain.MaintainDetail;
import com.management.domain.Maintain;
import com.baomidou.mybatisplus.extension.service.IService;
import com.management.domain.Result;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 保养表 服务类
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-19
 */
public interface MaintainService extends IService<Maintain> {
    /**
     * 添加保养日志、图片
     * @param maintain
     * @return
     */
    public Result<Boolean> insertMaintainLog(Maintain maintain, MultipartFile[] files);

    /**
     * 不定参数查询保养记录
     */
    public Result<List<Maintain>> selectMaintainLogs(Maintain maintain, String startTime, String endTime);

    /**
     * 查询某个保养记录的详细信息
     */
    public Result<MaintainDetail> selectMaintaindetails(Integer maintainId);
}
