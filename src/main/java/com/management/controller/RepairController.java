package com.management.controller;

import cn.hutool.json.JSONUtil;
import com.management.domain.Repair;
import com.management.domain.RepairDetail;
import com.management.domain.Result;
import com.management.service.RepairService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public Result<Boolean> insertRepairTask(@RequestPart(name = "repair") String repair, MultipartRequest files) {
        Repair repairObj = JSONUtil.toBean(repair, Repair.class, true);
        List<MultipartFile> multipartFiles = new ArrayList<>();
        files.getFileMap().forEach((key, multipartFile) -> {
            multipartFiles.add(multipartFile);
        });
        return repairService.insertRepairTask(repairObj, multipartFiles);
    }

    @PostMapping("/select")
    public Result<List<RepairDetail>> selectRepairs(@RequestBody RepairDetail repair, @RequestParam(name = "startTime", defaultValue = "", required = false) String startTime, @RequestParam(name = "endTime", defaultValue = "", required = false) String endTime, @RequestParam(name = "type", defaultValue = "", required = false) Boolean type) {
        System.out.println(repair.toString());
        return repairService.selectRepairs(repair, startTime, endTime, type);
    }

    @PostMapping("/update")
    public Result<Boolean> undateRepair(@RequestBody Repair repair) {
        return repairService.updateRepair(repair);
    }
}
