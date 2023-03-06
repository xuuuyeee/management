package com.management.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceAndAddress {
    private Integer deviceId;
    private String deviceName;
    private LocalDateTime deviceMaintainTime;
    private String memberName;
    private String devicePicPath;
    private Integer deviceAddress;
    private Integer addressFloor;
    private Integer addressRoom;
    private Integer addressBuilding;
}
