package com.management.service;

import com.management.domain.PartLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.management.domain.PartLogDetail;
import com.management.domain.Result;

import java.util.List;

/**
 * <p>
 * 零件日志 服务类
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-19
 */
public interface PartLogService extends IService<PartLog> {
    /**
     * 添加零件使用日志
     * @param partLog
     * @return
     */
    public Result<Boolean> insertPartLog(PartLog partLog);

    /**
     * 查询零件日志
     */
    public Result<List<PartLogDetail>> selectPartLogs(PartLogDetail partLog,String startTime,String endTime);
}
