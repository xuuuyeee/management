package com.management.controller;

import com.management.domain.MainPageData;
import com.management.domain.Result;
import com.management.service.MainPageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 保养图片表 前端控制器
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-19
 */
@RestController
@RequestMapping("/")
public class mainPageController {
    @Resource
    private MainPageService mainPageService;
    @GetMapping("/main")
    public Result<MainPageData> mainPageData(@RequestParam Integer id){
        return mainPageService.getMainPageData(id);
    }
}
