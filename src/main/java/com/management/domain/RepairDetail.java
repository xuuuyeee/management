package com.management.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepairDetail {
    private Integer repairId;
    private String commitMemberName;
    private String repairCommitReason;
    private String repairMemberName;
    private Integer addressBuilding;
    private Integer addressFloor;
    private Integer addressRoom;
    private String deviceName;
    private LocalDateTime repairCommitTime;
    private LocalDateTime repairTime;
    private Integer repairStatus;
    private List<RepairPic> repairPicList;
}
