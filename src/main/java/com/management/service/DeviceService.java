package com.management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.management.domain.Device;
import com.management.domain.DeviceAndAddress;
import com.management.domain.Result;
import org.springframework.web.multipart.MultipartFile;

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
     *
     * @param device
     * @return
     */
    public Result<Boolean> insertDevice(Device device, MultipartFile file);

    /**
     * 查询设备
     */
    public Result<List<DeviceAndAddress>> selectDevices(Device device, String startTime, String endTime);

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

    /**
     * 获取设备详细信息
     */
    public Result<Device> detailDeviceInfo(Integer device);
}
