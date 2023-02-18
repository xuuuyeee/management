package com.management.controller;

import cn.hutool.core.date.DateUtil;
import com.management.domain.Code;
import com.management.domain.Device;
import com.management.domain.Result;
import com.management.service.DeviceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 设备表 前端控制器
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-16
 */
@RestController
@CrossOrigin
@RequestMapping("/device")
public class DeviceController {
    @Resource
    private DeviceService deviceService;
    @PostMapping("/select")
    public Result<List<Device>> selectDeviceInfo(@RequestBody(required = false) Device device, @RequestParam(name = "startTime", defaultValue = "", required = false) String startTime,  @RequestParam(name = "endTime", defaultValue = "", required = false) String endTime){
        if(startTime == null || startTime.length()  == 0) startTime = "1970-01-01";
        if(endTime == null || endTime.length() == 0) endTime = DateUtil.formatDate(new Date(System.currentTimeMillis()));
        System.out.println(DateUtil.beginOfDay(DateUtil.parse(startTime,"yyyy-MM-dd")));
        System.out.println(DateUtil.endOfDay(DateUtil.parse(endTime,"yyyy-MM-dd")));
        return deviceService.selectDevices(device,DateUtil.beginOfDay(DateUtil.parse(startTime,"yyyy-MM-dd")).toString(),DateUtil.endOfDay(DateUtil.parse(endTime,"yyyy-MM-dd")).toString());
    }
    @PostMapping("/add")
    public Result<Boolean> insertDevice(@RequestBody Device device){
        return  deviceService.insertDevice(device);
    }
    @DeleteMapping("/delete")
    public Result<Boolean> deleteDevice(@RequestParam Integer deviceId){
        return deviceService.deleteDevice(deviceId);
    }
    @PutMapping("/update")
    public Result<Boolean> updateDevice(@RequestBody Device device){
        if(deviceService.updateDevice(device)) return new Result<>(true, Code.Update_Success,"更新成功");
        else return new Result<>(false,Code.Update_Failure,"更新失败");
    }
}
