package com.management.service.impl;

import com.management.domain.Code;
import com.management.domain.PartLog;
import com.management.dao.PartLogMapper;
import com.management.domain.PartLogDetail;
import com.management.domain.Result;
import com.management.service.PartLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 零件日志 服务实现类
 * </p>
 *
 * @author xuuuyeee
 * @since 2023-01-19
 */
@Service
public class PartLogServiceImpl extends ServiceImpl<PartLogMapper, PartLog> implements PartLogService {
    @Autowired
    private  PartLogMapper partLogMapper;

    @Override
    public Result<Boolean> insertPartLog(PartLog partLog) {
        if(partLogMapper.insert(partLog) != 0) return  new Result<>(true, Code.Insert_Success,"插入成功");
        else return new Result<>(false,Code.Insert_Failure,"插入失败");
    }

    @Override
    public Result<List<PartLogDetail>> selectPartLogs(PartLogDetail partLogDetail,String startTime,String endTime) {
        List<PartLogDetail> list = partLogMapper.selectPartLogs(partLogDetail,startTime,endTime);
        if(!list.isEmpty()) return  new Result<>(list,Code.Select_Success,"查询成功");
        else return new Result(false,Code.Select_Null,"查询为空");
    }


}
