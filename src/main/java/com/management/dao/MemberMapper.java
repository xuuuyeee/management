package com.management.dao;

import com.management.domain.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 人员表 Mapper 接口
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-16
 */
@Mapper
public interface MemberMapper extends BaseMapper<Member> {
    public List<Member> selectMembers(@Param("Member") Member member,@Param("state") Boolean state);
}
