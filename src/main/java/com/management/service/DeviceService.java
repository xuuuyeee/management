package com.management.service;

import com.management.domain.Device;
import com.baomidou.mybatisplus.extension.service.IService;
import com.management.domain.Result;

import java.util.List;

/**
 * <p>
 * 设备表 服务类
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-16
 */
public interface DeviceService extends IService<Device> {
    /**
     * 添加设备
     * @param device
     * @return
     */
    public Result<Boolean> insertDevice(Device device);
    /**
     * 查询设备
     */
    public Result<List<Device>> selectDevices(Device device,String startTime,String endTime);
    /**
     * 更新设备的时间
     */
    public Boolean updateDevice(Device device);
    /**
     * 删除设备
     */
    public Result<Boolean> deleteDevice(Integer deviceId);

    /**
     * 定时器任务，更新设备状态
     * updateDeviceStatus
     */
    public long updateDeviceStatus();
}
