package com.management.dao;

import com.management.domain.MaintainDetail;
import com.management.domain.Maintain;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 保养表 Mapper 接口
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-19
 */
@Mapper
public interface MaintainMapper extends BaseMapper<Maintain> {
    public List<Maintain> selectMaintainLogs(@Param("Maintain") Maintain maintain, @Param("startTime")String startTime,@Param("endTime") String endTime);

    public MaintainDetail selectMaintainDetails(@Param("maintainId") Integer maintainId);
}
