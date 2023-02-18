package com.management.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartLogDetail {
    private Integer partLogId;
    private String partName;
    private Integer partQuantity;
    private String memberName;
    private Integer partTaskType;
    private Integer partTaskId;
    private String deviceName;
    private Date useTime;
}
