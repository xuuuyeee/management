package com.management.service.impl;

import com.management.domain.Code;
import com.management.domain.Device;
import com.management.dao.DeviceMapper;
import com.management.domain.Result;
import com.management.service.DeviceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 设备表 服务实现类
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-16
 */
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {
    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public Result<Boolean> insertDevice(Device device) {
        if(deviceMapper.insert(device) != 0) return new Result<Boolean>(true, Code.Insert_Success,"插入成功");
        else return new Result<Boolean>(false,Code.Insert_Failure,"插入失败");
    }

    @Override
    public Result<List<Device>> selectDevices(Device device,String startTime,String endTime) {
        List list = deviceMapper.selectDevices(device,startTime,endTime);
        System.out.println(device.toString());
        if(list.isEmpty()) return new Result(false,Code.Select_Null,"暂无设备");
        else return new Result<List<Device>>(list,Code.Select_Success,"查询成功");
    }

    @Override
    public Boolean updateDevice(Device device) {
        if(deviceMapper.updateById(device) != 0 ) return true;
        else return  false;
    }

    @Override
    public Result<Boolean> deleteDevice(Integer deviceId) {
        if(deviceMapper.deleteById(deviceId) != 0 ) return  new Result<Boolean>(true,Code.Delete_Success,"删除成功");
        else return new Result<Boolean>(false,Code.Delete_Failure,"删除失败");
    }

    @Override
    public long updateDeviceStatus() {
        return deviceMapper.updateDeviceStatus();
    }


}
