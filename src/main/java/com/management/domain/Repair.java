package com.management.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

/**
 * <p>
 * 维修表
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_repair")
public class Repair implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 事务ID
     */
    @TableId(value = "REPAIR_ID", type = IdType.AUTO)
    private Integer repairId;

    /**
     * 报修人ID
     */
    @TableField("REPAIR_COMMIT_ID")
    private Integer repairCommitId;

    /**
     * 报修原因
     */
    @TableField("REPAIR_COMMIT_REASON")
    private String repairCommitReason;

    /**
     * 维修人ID
     */
    @TableField("REPAIR_MEMBER_ID")
    private Integer repairMemberId;

    /**
     * 报修地点
     */
    @TableField("REPAIR_ADDRESS_ID")
    private Integer repairAddressId;

    /**
     * 报修设备
     */
    @TableField("REPAIR_DEVICE_ID")
    private String repairDeviceId;

    /**
     * 报修时间
     */
    @TableField("REPAIR_COMMIT_TIME")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime repairCommitTime;

    /**
     * 任务状态
     */
    @TableField("REPAIR_STATUS")
    private Integer repairStatus;

    /**
     * 维修时间
     */
    @TableField("REPAIR_TIME")
    private LocalDateTime repairTime;
}
