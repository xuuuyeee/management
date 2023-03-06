package com.management.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MainPageData {
    private Integer deviceTotalNum;
    private Integer deviceRepairNum;
    private Integer deviceMaintainNum;
    private Integer memberTotalNumber;
    private Integer memberWorkNum;
    //    private Integer todayRepairTaskNum;
//    private Integer todayRepairOkNum;
//    private Integer maintainWillNumber;
//    private Integer maintainIngNumber;
    private Integer infoTotalNumber;
    private Integer sheetTotalNumber;

    private Integer okMaintainNumber;
    private Integer unOkRepairNumber;
}
