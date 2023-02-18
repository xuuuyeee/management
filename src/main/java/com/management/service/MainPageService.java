package com.management.service;

import com.management.domain.MainPageData;
import com.management.domain.Result;


public interface MainPageService{
    /**
     * 获取员工相关的数据
     * @param id
     * @return
     */
    public Result<MainPageData> getMainPageData(Integer id);
}
