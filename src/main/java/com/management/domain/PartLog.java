package com.management.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.*;

/**
 * <p>
 * 零件日志
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_part_log")
public class PartLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 零件日志ID
     */
    @TableId(value = "PART_LOG_ID", type = IdType.AUTO)
    private Integer partLogId;

    /**
     * 零件ID
     */
    @TableField("PART_ID")
    private Integer partId;

    /**
     * 零件数目
     */
    @TableField("PART_QUANTITY")
    private Integer partQuantity;

    /**
     * 申请人ID
     */
    @TableField("PART_MEMBER_ID")
    private Integer partMemberId;

    /**
     * 零件使用种类
     */
    @TableField("PART_TASK_TYPE")
    private Integer partTaskType;

    /**
     * 对应的任务ID
     */
    @TableField("PART_TASK_ID")
    private Integer partTaskId;

    /**
     * 对应的设备ID
     */
    @TableField("PART_DEVICE_ID")
    private Integer partDeviceId;

    /**
     * 使用零件的日期
     */
    @TableField("PART_USE_TIME")
    private Date partUseTime;
}
