package com.management.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.management.domain.Info;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 公告表 Mapper 接口
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-02-19
 */
@Mapper
public interface InfoMapper extends BaseMapper<Info> {

}
