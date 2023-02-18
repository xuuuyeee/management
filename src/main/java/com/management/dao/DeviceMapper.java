package com.management.dao;

import com.management.domain.Device;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 设备表 Mapper 接口
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-16
 */
@Mapper
public interface DeviceMapper extends BaseMapper<Device> {
    public List<Device> selectDevices(@Param("Device") Device device,@Param("startTime") String startTime,@Param("endTime") String endTime);

    public long updateDeviceStatus();
}
