package com.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.management.dao.MainPageMapper;
import com.management.dao.MemberMapper;
import com.management.domain.Code;
import com.management.domain.MainPageData;
import com.management.domain.Member;
import com.management.domain.Result;
import com.management.service.MainPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainPageServiceImpl implements MainPageService {
    @Autowired
    private MainPageMapper mainPageMapper;

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Result<MainPageData> getMainPageData(Integer id) {
        if (memberMapper.selectOne(new LambdaQueryWrapper<Member>().eq(Member::getMemberId, id)).getMemberLevel() != 0) {
            return null;
        } else return new Result<>(mainPageMapper.getCount(), Code.Select_Success, "查询成功");
    }
}
