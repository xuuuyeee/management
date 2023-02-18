package com.management.controller;

import com.management.domain.Code;
import com.management.domain.Part;
import com.management.domain.Result;
import com.management.service.PartService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 零件表 前端控制器
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-16
 */
@RestController
@RequestMapping("/part")
public class PartController {
    @Resource
    private PartService partService;
    @PostMapping("/add")
    public Result<Boolean> insertPart(@RequestBody Part part){ return partService.insertPart(part); }

    @PostMapping("/select")
    public Result<List<Part>> selectParts(@RequestBody Part part){ return partService.selectParts(part); }

    @PutMapping("/update")
    public Result<Boolean> updatePartInfo(@RequestBody Part part){
        if(partService.updatePart(part)) return new Result<>(true, Code.Update_Success,"更新成功");
        else return new Result<>(false,Code.Update_Failure,"更新失败");
    }
}
