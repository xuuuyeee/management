package com.management.controller;

import cn.hutool.core.date.DateUtil;
import com.management.domain.*;
import com.management.service.DeviceService;
import com.management.service.MaintainPicService;
import com.management.service.MaintainService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 保养表 前端控制器
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-19
 */
@RestController
@CrossOrigin
@RequestMapping("/maintain")
public class MaintainController {
    @Resource
    private MaintainService maintainService;
    @Resource
    private DeviceService deviceService;

    @Resource
    private MaintainPicService maintainPicService;

    @PostMapping("/add")
    public Result<Boolean> addMaintainLog(@RequestPart("maintain")  Maintain maintain, @RequestPart("file") MultipartFile[] files){
        System.out.println(maintain);
        Device device = new Device();
        device.setDeviceId(maintain.getMaintainDeviceId());
        device.setDeviceMaintainTime(LocalDateTime.ofEpochSecond(System.currentTimeMillis()/1000, 0, ZoneOffset.ofHours(8)));
        device.setDeviceMaintainMemberId(maintain.getMaintainMemberId());
        maintain.setMaintainTime(LocalDateTime.ofEpochSecond(System.currentTimeMillis()/1000, 0, ZoneOffset.ofHours(8)));
        if(deviceService.updateDevice(device)) return maintainService.insertMaintainLog(maintain,files);
        else return new Result(false, Code.Insert_Failure,"插入失败");
    }


    @PostMapping("/select")
    public Result<List<Maintain>> selectMaintainLogs(@RequestBody(required = false) Maintain maintain, @RequestParam(required = false,defaultValue = "") String startTime, @RequestParam(required = false, defaultValue ="") String endTime){
        if(startTime == null || startTime.length()  == 0) startTime = "1970-01-01";
        if(endTime == null || endTime.length() == 0) endTime = DateUtil.formatDate(new Date(System.currentTimeMillis()));
        System.out.println(DateUtil.beginOfDay(DateUtil.parse(startTime,"yyyy-MM-dd")).toString());
        System.out.println(DateUtil.endOfDay(DateUtil.parse(endTime,"yyyy-MM-dd")).toString());
        return maintainService.selectMaintainLogs(maintain,DateUtil.beginOfDay(DateUtil.parse(startTime,"yyyy-MM-dd")).toString(),DateUtil.endOfDay(DateUtil.parse(endTime,"yyyy-MM-dd")).toString());
    }

    @GetMapping("/details")
    public Result<MaintainDetail> selectMaintaindetails(@RequestParam Integer maintainId){
        return  maintainService.selectMaintaindetails(maintainId);
    }
}
