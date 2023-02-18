package com.management.dao;

import com.management.domain.Repair;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.management.domain.RepairDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 维修表 Mapper 接口
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-19
 */
@Mapper
public interface RepairMapper extends BaseMapper<Repair> {
    public List<RepairDetail> selectRepairs(@Param("Repair") RepairDetail repairDetail,@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("type")Boolean type);
}
