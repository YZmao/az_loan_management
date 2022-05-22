package com.myz.azloanmanage.service.impl;

import com.myz.azloanmanage.entity.CustomerStatus;
import com.myz.azloanmanage.mapper.CustomerStatusMapper;
import com.myz.azloanmanage.service.CustomerStatusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客户状态 服务实现类
 * </p>
 *
 * @author myz.azloanmanage
 * @since 2022-05-22
 */
@Service
public class CustomerStatusServiceImpl extends ServiceImpl<CustomerStatusMapper, CustomerStatus> implements CustomerStatusService {

}
