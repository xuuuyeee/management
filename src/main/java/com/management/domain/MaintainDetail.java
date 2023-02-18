package com.management.domain;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaintainDetail {
    private Integer maintainId;
    private String memberName;
    private String deviceName;
    private Integer addressBuilding;
    private Integer addressFloor;
    private Integer addressRoom;
    private LocalDateTime maintainTime;
    private List<MaintainPic> maintainPicList;
}
