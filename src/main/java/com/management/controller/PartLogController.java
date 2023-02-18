package com.management.controller;

import cn.hutool.core.date.DateUtil;
import com.management.domain.PartLog;
import com.management.domain.PartLogDetail;
import com.management.domain.Result;
import com.management.service.PartLogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 零件日志 前端控制器
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-19
 */
@RestController
@RequestMapping("/partLog")
public class PartLogController {
    @Resource
    private PartLogService partLogService;

    @PostMapping("/add")
    public Result<Boolean> insertPartLog(@RequestBody PartLog partLog){
        return partLogService.insertPartLog(partLog);
    }

    @PostMapping("/select")
    public Result<List<PartLogDetail>> selectPartLogs(@RequestBody PartLogDetail partLogDetail, @RequestParam(name = "startTime", required = false,defaultValue = "") String startTime, @RequestParam(name = "endTime",required = false,defaultValue = "") String endTime){
        if(startTime.isEmpty()) startTime = "1970-01-01";
        if(endTime.isEmpty()) endTime = DateUtil.today();
        return partLogService.selectPartLogs(partLogDetail,startTime,endTime);
    }

}
