package com.management.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 设备表
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_device")
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 设备ID
     */
    @TableId(value = "DEVICE_ID", type = IdType.AUTO)
    private Integer deviceId;

    /**
     * 设备名
     */
    @TableField("DEVICE_NAME")
    private String deviceName;

    /**
     * 设备最近保养时间
     */
    @TableField("DEVICE_MAINTAIN_TIME")
    private LocalDateTime deviceMaintainTime;

    /**
     * 设备最近保养人
     */
    @TableField("DEVICE_MAINTAIN_MEMBER_ID")
    private Integer deviceMaintainMemberId;

    /**
     * 设备最近状态
     */
    @TableField("DEVICE_STATUS")
    private Integer deviceStatus;

    /**
     * 设备地址
     */
    @TableField("DEVICE_ADDRESS")
    private Integer deviceAddress;

    /**
     * 设备图片路径
     */
    @TableField("DEVICE_PIC_PATH")
    private String devicePicPath;
}
