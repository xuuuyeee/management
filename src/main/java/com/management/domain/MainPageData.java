package com.management.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MainPageData {
    private Integer deviceTotalNum;
    private Integer deviceRepairNum;
    private Integer deviceMaintainNum;
    private Integer memberWorkNum;
    private Integer memberTotalMember;
    private Integer todayRepairTaskNum;
    private Integer todayRepairOkNum;
    private Integer maintainWillNumber;
    private Integer maintainIngNumber;
}
