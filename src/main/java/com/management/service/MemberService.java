package com.management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.management.domain.Member;
import com.management.domain.Result;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 人员表 服务类
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-16
 */
public interface MemberService extends IService<Member> {
    /**
     * 测试用方法
     */
    public void test();

    /**
     * 登录方法
     */
    public Result<Member> login(String userName, String password);

    /**
     *  注册方法
     */
    public Result<Boolean> register(String name ,String userName,String password);

    /**
     * 更新管理员信息
     * By 维修员工 管理员 普通人
     */
    public Result<Boolean> updateMemberInfo(Member member, MultipartFile file);

    /**
     * 搜索员工
     * @return
     */
    public Result<List<Member>> selectMember(Member member,Boolean state);
}
