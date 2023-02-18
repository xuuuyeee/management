package com.management.service.impl;

import com.management.dao.MainPageMapper;
import com.management.domain.Code;
import com.management.domain.MainPageData;
import com.management.domain.Result;
import com.management.service.MainPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainPageServiceImpl implements MainPageService {
    @Autowired
    private MainPageMapper mainPageMapper;
    @Override
    public Result<MainPageData> getMainPageData(Integer id) {
       return new Result<>(mainPageMapper.getCount(), Code.Select_Success,"查询成功");
    }
}
