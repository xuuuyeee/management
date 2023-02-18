package com.management.dao;

import com.management.domain.Address;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 房间号 Mapper 接口
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-16
 */
@Mapper
public interface AddressMapper extends BaseMapper<Address> {
    public List<Address> selectRooms(@Param("address") Address address);
}
