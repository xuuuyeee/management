package com.management.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.*;

/**
 * <p>
 * 维修图片表
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_repair_pic")
public class RepairPic implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 维修图片ID
     */
    @TableId(value = "REPAIR_PIC_ID", type = IdType.AUTO)
    private Integer repairPicId;

    /**
     * 所属维修任务ID
     */
    @TableField("REPAIR_ID")
    private Integer repairId;

    /**
     * 维修图片路径
     */
    @TableField("REPAIR_PIC_PATH")
    private String repairPicPath;

//    @TableField("REPAIR_PIC_TYPE")
//    private Integer repairPicType;
}
