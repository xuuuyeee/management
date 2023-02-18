package com.management.service.impl;

import com.management.domain.Address;
import com.management.dao.AddressMapper;
import com.management.domain.Code;
import com.management.domain.Result;
import com.management.service.AddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 房间号 服务实现类
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-16
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {
    @Autowired
    private AddressMapper addressMapper;
    @Override
    public Result<Boolean> insertRoom(Address address) {
        if(addressMapper.insert(address) != 0) return  new Result(true, Code.Insert_Success,"插入成功");
        return new Result<>(false,Code.Insert_Failure,"插入失败");
    }

    @Override
    public Result<List<Address>> selectRooms(Address address) {
        List<Address> list = addressMapper.selectRooms(address);
        if(list.isEmpty())  return  new Result(false,Code.Select_Null,"没有房间登记在册");
        else return new Result(list,Code.Select_Success,"查询成功");
    }

    @Override
    public Result<Boolean> updateRoomInfo(Address address) {
        if(addressMapper.updateById(address) != 0 ) return  new Result(false,Code.Update_Success,"地址信息更新成功");
        else return new Result(true, Code.Update_Failure, "更新失败");
    }

    @Override
    public Result<Boolean> deleteRoomInfo(Integer addressId) {
        if(addressMapper.deleteById(addressId) != 0) return new Result<Boolean>(true,Code.Delete_Success,"删除成功");
        else return new Result<Boolean>(false, Code.Delete_Failure,"删除失败");
    }
}
