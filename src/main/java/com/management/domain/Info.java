package com.management.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 公告表
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-02-19
 */
@Data
@NoArgsConstructor
@TableName("sys_info")
public class Info implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公告ID
     */
    @TableId("INFO_ID")
    private Integer infoId;

    /**
     * 公告标题
     */
    @TableField("INFO_TITLE")
    private String infoTitle;

    /**
     * 公告类型
     */
    @TableField("INFO_LEVEL")
    private Integer infoLevel;

    /**
     * 公告内容
     */
    @TableField("INFO_CONTENT")
    private String infoContent;
}
