package com.management.controller;

import cn.hutool.json.JSONUtil;
import com.management.domain.Member;
import com.management.domain.Result;
import com.management.service.MemberService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 人员表 前端控制器
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-16
 */
@RestController
@CrossOrigin
@RequestMapping("/member")
public class MemberController {
    @Resource
    private MemberService memberService;

    @PostMapping("/select")
    public Result<List<Member>> selectMembers(@RequestBody Member member, @RequestParam(name = "state", defaultValue = "", required = false) Boolean state) {
        return memberService.selectMember(member, state);
    }

    @PostMapping("/login")
    public Result<Member> login(@RequestBody Member member) {
        return memberService.login(member.getMemberUsername(), member.getMemberPassword());
    }

    @PostMapping("/register")
    public Result<Boolean> register(@RequestBody Member member) {
        return memberService.register(member.getMemberName(), member.getMemberUsername(), member.getMemberPassword());
    }

    @PostMapping(value = "/update", consumes = "multipart/form-data")
    public Result<Boolean> updateInfo(@RequestPart("member") String member, @RequestPart(name = "file", required = false) MultipartFile file) {
        Member memberObj = JSONUtil.toBean(member, Member.class, true);
        System.out.println(memberObj);
//        if(file == null)
//        System.out.println(file.getName());
        return memberService.updateMemberInfo(memberObj, file);
    }
}


