package com.management.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.management.domain.MainPageData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainPageMapper extends BaseMapper<MainPageData> {
    public MainPageData getCount();
}
