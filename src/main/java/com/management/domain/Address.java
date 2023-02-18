package com.management.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.*;

/**
 * <p>
 * 房间号
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_address")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 地址ID
     */
    @TableId(value = "ADDRESS_ID", type = IdType.AUTO)
    private Integer addressId;

    /**
     * 楼栋号
     */
    @TableField("ADDRESS_BUILDING")
    private Integer addressBuilding;

    /**
     * 楼层号
     */
    @TableField("ADDRESS_FLOOR")
    private Integer addressFloor;

    /**
     * 房间号
     */
    @TableField("ADDRESS_ROOM")
    private Integer addressRoom;
}
