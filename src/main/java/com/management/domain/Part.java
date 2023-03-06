package com.management.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 零件表
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-03-04
 */
@Getter
@Setter
@NoArgsConstructor
@TableName("sys_part")
public class Part implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 零件ID
     */
    @TableId(value = "PART_ID", type = IdType.AUTO)
    private Integer partId;

    /**
     * 零件名
     */
    @TableField("PART_NAME")
    private String partName;

    /**
     * 零件数
     */
    @TableField("PART_QUANTITY")
    private Integer partQuantity;

    /**
     * 零件编号
     */
    @TableField("PART_NUM")
    private String partNum;

    /**
     * 零件型号
     */
    @TableField("PART_CODE")
    private String partCode;

    /**
     * 零件单价
     */
    @TableField("PART_SPRICE")
    private Integer partSprice;

    /**
     * 零件单位
     */
    @TableField("PART_DANWEI")
    private String partDanwei;

    /**
     * 零件库存警告
     */
    @TableField("PART_ALERT")
    private Integer partAlert;

    /**
     * 零件厂商
     */
    @TableField("PART_FACTORY")
    private String partFactory;

    /**
     * 零件图片地址
     */
    @TableField("PART_PIC_PATH")
    private String partPicPath;
}
