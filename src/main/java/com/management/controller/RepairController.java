package com.management.controller;

import com.management.domain.Repair;
import com.management.domain.RepairDetail;
import com.management.domain.Result;
import com.management.service.RepairService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 维修表 前端控制器
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-19
 */
@RestController
@RequestMapping("/repair")
public class RepairController {
    @Resource
    private RepairService repairService;

    @PostMapping("/add")
    public Result<Boolean> insertRepairTask(@RequestPart(name ="repair") Repair repair, @RequestPart(name = "files", required = false) MultipartFile[] files){
        return repairService.insertRepairTask(repair,files);
    }

    @PostMapping("/select")
    public Result<List<RepairDetail>> selectRepairs(@RequestBody RepairDetail repair, @RequestParam(name = "startTime",defaultValue = "",required = false) String startTime, @RequestParam(name = "endTime", defaultValue = "",required = false)String endTime,@RequestParam(name = "type", defaultValue = "",required = false)Boolean type){
        return repairService.selectRepairs(repair,startTime,endTime,type);
    }
}
