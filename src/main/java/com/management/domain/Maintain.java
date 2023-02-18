package com.management.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.*;

/**
 * <p>
 * 保养表
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_maintain")
public class Maintain implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 保养ID
     */
    @TableId(value = "MAINTAIN_ID", type = IdType.AUTO)
    private Integer maintainId;

    /**
     * 保养人ID
     */
    @TableField("MAINTAIN_MEMBER_ID")
    private Integer maintainMemberId;

    /**
     * 保养设备ID
     */
    @TableField("MAINTAIN_DEVICE_ID")
    private Integer maintainDeviceId;

    /**
     * 保养地区ID
     */
    @TableField("MAINTAIN_ADDRESS_ID")
    private Integer maintainAddressId;

    /**
     * 保养时间
     */
    @TableField("MAINTAIN_TIME")
    private LocalDateTime maintainTime;

}
