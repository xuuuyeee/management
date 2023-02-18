package com.management.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.*;
import org.apache.ibatis.annotations.ConstructorArgs;

/**
 * <p>
 * 人员表
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_member")

public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 人员ID
     */
    @TableId(value = "MEMBER_ID", type = IdType.AUTO)
    private Integer memberId;

    /**
     * 人员级别
     */
    @TableField("MEMBER_LEVEL")
    private Integer memberLevel;

    /**
     * 人员姓名
     */
    @TableField("MEMBER_NAME")
    private String memberName;

    /**
     * 人员头像
     */
    @TableField("MEMBER_PIC")
    private String memberPic;

    /**
     * 人员负责区域
     */
    @TableField("MEMBER_REPAIR_AREA")
    private String memberRepairArea;

    /**
     * 人员用户名
     */
    @TableField("MEMBER_USERNAME")
    private String memberUsername;

    /**
     * 人员账户密码
     */
    @TableField("MEMBER_PASSWORD")
    private String memberPassword;

    public Member(String name, String userName, String password) {
        this.memberName = name;
        this.memberUsername = userName;
        this.memberPassword = password;
    }

}
