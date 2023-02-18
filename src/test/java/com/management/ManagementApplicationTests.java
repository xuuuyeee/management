package com.management;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.management.dao.MaintainMapper;
import com.management.domain.Maintain;
import com.management.domain.Member;
import com.management.service.MaintainService;
import com.management.service.MemberService;
import com.management.service.PartService;
import com.sun.tools.javac.Main;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ManagementApplicationTests {
    @Autowired
    private MemberService memberService;
    @Autowired
    private PartService partService;
    @Autowired
    private MaintainService maintainService;
    @Autowired
    private MaintainMapper maintainMapper;
    @Test
    void contextLoads() {
//        System.out.println(memberService.login("xuuuyeee","Ff332626"));
//        System.out.println(memberService.register("刘昊熙","lhx","666666"));
//        System.out.println(memberService.login("xuuuyeee","Ff332626"));
//        System.out.println(memberService.upGradeOrDownGrade(1,0));

//        Member member = new Member();
//        member.setMemberId(1);
//        member.setMemberPic("good");
//        System.out.println(memberService.updateMemberInfo(member));
//        Maintain maintain = new Maintain();
//        maintain.setMaintainAddressId(1);
//        System.out.println(m  yyyy-MM-dd HH:mm:ss

//        System.out.println(DateUtil.beginOfDay(DateUtil.parse("","yyyy-MM-dd")));
//        System.out.println(DateUtil.endOfDay(DateUtil.parse("","yyyy-MM-dd")));
        System.out.println(maintainMapper.selectMaintainDetails(1));
       }

}
