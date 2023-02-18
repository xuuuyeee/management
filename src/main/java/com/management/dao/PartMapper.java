package com.management.dao;

import com.management.domain.Part;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 零件表 Mapper 接口
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-16
 */
@Mapper
public interface PartMapper extends BaseMapper<Part> {
    public List<Part> selectParts(@Param("part") Part part);
}
