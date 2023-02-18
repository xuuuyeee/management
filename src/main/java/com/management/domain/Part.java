package com.management.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.*;

/**
 * <p>
 * 零件表
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    public Part(String partName,Integer partQuantity){
        this.partName = partName;
        this.partQuantity = partQuantity;
    }
}
