package com.management.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.*;

/**
 * <p>
 * 保养图片表
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_maintain_pic")
public class MaintainPic implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 保养图片ID
     */
    @TableId(value = "MAINTAIN_PIC_ID", type = IdType.AUTO)
    private Integer maintainPicId;

    /**
     * 保养图片的地址
     */
    @TableField("MAINTAIN_PIC_PATH")
    private String maintainPicPath;

    /**
     * 保养任务的ID
     */
    @TableField("MAINTAIN_ID")
    private Integer maintainId;
}
