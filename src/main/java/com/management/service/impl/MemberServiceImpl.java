package com.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.management.dao.MemberMapper;
import com.management.domain.Code;
import com.management.domain.Member;
import com.management.domain.Result;
import com.management.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 人员表 服务实现类
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-16
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {
    @Autowired
    private MemberMapper memberMapper;
    @Override
    public void test() {
        System.out.println("hello world");
    }

    @Value("${spring.servlet.multipart.location}")
    private String uploadRoot;
    @Value("${spring.servlet.multipart.location}" + "/member/")
    private  String uploadRootPath;

    @Override
    public Result<Member> login(String userName, String password) {
        Member member = memberMapper.selectOne(new LambdaQueryWrapper<Member>().eq(Member::getMemberUsername, userName).eq(Member::getMemberPassword, password));
        if (member != null) {
            member.setMemberPassword("");
            return new Result(member, Code.Login_Success, "登录成功");
        } else return new Result(false, Code.Login_Failure, "登录失败，检查用户名与密码是否匹配");
    }

    @Override
    public Result<Boolean> register(String name, String userName, String password) {
        if(memberMapper.selectOne(new LambdaQueryWrapper<Member>().eq(Member::getMemberUsername,userName)) != null){
            return  new Result(false,Code.Register_Repeat, "该用户名已存在，注册失败");
        }
        if (memberMapper.insert(new Member(name,userName,password)) == 0) return new Result(false,Code.Register_Failure,"注册失败，请重试");
        else return new Result(true,Code.Register_Success,"注册成功");
    }

    @Override
    public Result<Boolean> updateMemberInfo(Member member, MultipartFile file) {

        if (file != null) {
            String orgName = file.getOriginalFilename();
            String extName = orgName.substring(orgName.lastIndexOf('.'));
            String destName = UUID.randomUUID().toString().toUpperCase() + extName;
            try {
                file.transferTo(new File(uploadRootPath, destName));
                member.setMemberPic("/member/" + destName);
                String picPath = memberMapper.selectOne(new LambdaQueryWrapper<Member>().select().eq(Member::getMemberId, member.getMemberId())).getMemberPic();
                if (!picPath.isEmpty()) new File(uploadRoot, picPath).delete();
                if (memberMapper.updateById(member) != 0) {
                    return new Result<Boolean>(true, Code.Update_Success, "更新成功");
                } else return new Result<Boolean>(false, Code.Update_Failure, "更新失败");
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
                return new Result<Boolean>(false,Code.Insert_Failure,"人物头像上传失败");
            }
        }else{
            if(memberMapper.updateById(member) != 0 ) return new Result<Boolean>(true,Code.Update_Success,"更新成功");
            else return new Result<Boolean>(false,Code.Update_Failure,"更新失败");
        }
    }

    @Override
    public Result<List<Member>> selectMember(Member member,Boolean state) {
       List<Member> list = memberMapper.selectMembers(member,state);
       if(list.isEmpty()) return new Result(false,Code.Select_Null,"查询为空");
       else return new Result<List<Member>>(list,Code.Select_Success,"查询成功");
    }




}
