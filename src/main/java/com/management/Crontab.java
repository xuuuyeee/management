package com.management;

import com.management.dao.DeviceMapper;
import com.management.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Crontab {
    @Autowired
    private DeviceService deviceService;

    @Scheduled(cron = "${schedules.runBatch}")
    public void crontab() throws Exception {
        System.out.println("hello");
        Long num = deviceService.updateDeviceStatus();
        System.out.println("更新了" + num);
    }
}
