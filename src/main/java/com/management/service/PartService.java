package com.management.service;

import com.management.domain.Part;
import com.baomidou.mybatisplus.extension.service.IService;
import com.management.domain.Result;

import java.util.List;

/**
 * <p>
 * 零件表 服务类
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-16
 */
public interface PartService extends IService<Part> {
    /**
     * 零件添加
     * 管理员使用
     */
    public Result<Boolean> insertPart(Part part);

    /**
     * 全部零件查询
     */
    public Result<List<Part>> selectParts(Part part);

    /**
     * 更新零件信息
     * @param part
     * @return
     */
    public Boolean updatePart(Part part);
}
