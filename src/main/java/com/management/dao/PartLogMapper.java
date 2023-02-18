package com.management.dao;

import com.management.domain.PartLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.management.domain.PartLogDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 零件日志 Mapper 接口
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-19
 */
@Mapper
public interface PartLogMapper extends BaseMapper<PartLog> {
    public List<PartLogDetail> selectPartLogs(@Param("partLog") PartLogDetail partLogDetail,@Param("startTime") String startTime,@Param("endTime") String endTime);
}
