package com.management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.management.dao.DeviceMapper;
import com.management.domain.Code;
import com.management.domain.Device;
import com.management.domain.DeviceAndAddress;
import com.management.domain.Result;
import com.management.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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

    @Value("${spring.servlet.multipart.location}" + "/device/")
    private String uploadRootPath;

    @Override
    public Result<Boolean> insertDevice(Device device, MultipartFile file) {
        if (!file.isEmpty()) {
            String orgName = file.getOriginalFilename();
            String extName = orgName.substring(orgName.lastIndexOf('.'));
            String destName = UUID.randomUUID().toString().toUpperCase() + extName;
            try {
                file.transferTo(new File(uploadRootPath, destName));
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
                return new Result<Boolean>(false, Code.Insert_Failure, "设备图片上传失败");
            }
            device.setDevicePicPath("/device/" + destName);
        }
        if (deviceMapper.insert(device) != 0) return new Result<Boolean>(true, Code.Insert_Success, "插入成功");
        else return new Result<Boolean>(false, Code.Insert_Failure, "插入失败");
    }

    @Override
    public Result<List<DeviceAndAddress>> selectDevices(Device device, String startTime, String endTime) {
        List list = deviceMapper.selectDevices(device, startTime, endTime);
        System.out.println(device.toString());
        if (list.isEmpty()) return new Result(false, Code.Select_Null, "暂无设备");
        else return new Result<List<DeviceAndAddress>>(list, Code.Select_Success, "查询成功");
    }

    @Override
    public Boolean updateDevice(Device device) {
        if(deviceMapper.updateById(device) != 0 ) return true;
        else return  false;
    }

    @Override
    public Result<Boolean> deleteDevice(Integer deviceId) {
        if (deviceMapper.deleteById(deviceId) != 0) return new Result<Boolean>(true, Code.Delete_Success, "删除成功");
        else return new Result<Boolean>(false, Code.Delete_Failure, "删除失败");
    }

    @Override
    public long updateDeviceStatus() {
        return deviceMapper.updateDeviceStatus();
    }

    @Override
    public Result<Device> detailDeviceInfo(Integer deviceId) {

        return null;
    }


}
