package com.management.service;

import com.management.domain.Address;
import com.baomidou.mybatisplus.extension.service.IService;
import com.management.domain.Result;

import java.util.List;

/**
 * <p>
 * 房间号 服务类
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-16
 */
public interface AddressService extends IService<Address> {
    /**
     * 添加房间
     * 管理员使用
     * @param address
     * @return
     */
    public Result<Boolean> insertRoom(Address address);

    /**
     * 展示房间
     * @return
     */
    public Result<List<Address>> selectRooms(Address address);

    /**
     * 修改单个地址信息
     * 管理员使用
     * @param address
     * @return
     */
    public Result<Boolean> updateRoomInfo(Address address);

    /**
     * 删除地址信息
     */
    public Result<Boolean> deleteRoomInfo(Integer addressId);
}
