package com.management.controller;

import com.management.domain.Address;
import com.management.domain.Result;
import com.management.service.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 房间号 前端控制器
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-16
 */
@RestController
@CrossOrigin
@RequestMapping("/address")
public class AddressController {
    @Resource
    private AddressService addressService;

    @PostMapping("/add")
    public Result<Boolean> insertAddressInfo(@RequestBody  Address address){ return  addressService.insertRoom(address); }

    @PostMapping("/select")
    public Result<List<Address>> selectAddressInfo(@RequestBody Address address){
        return  addressService.selectRooms(address);
    }
    @DeleteMapping("/delete")
    public Result<Boolean> deleteAddressInfo(@RequestParam("addressId")  Integer addressId){
        return addressService.deleteRoomInfo(addressId);
    }
    @PutMapping("/update")
    public Result<Boolean> updateAddressInfo(@RequestBody Address address){
        return addressService.updateRoomInfo(address);
    }
}
