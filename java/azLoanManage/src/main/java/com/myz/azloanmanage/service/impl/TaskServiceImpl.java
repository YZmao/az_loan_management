package com.myz.azloanmanage.service.impl;

import com.myz.azloanmanage.entity.Task;
import com.myz.azloanmanage.mapper.TaskMapper;
import com.myz.azloanmanage.service.TaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务经理当前任务情况 服务实现类
 * </p>
 *
 * @author myz.azloanmanage
 * @since 2022-05-22
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

}
