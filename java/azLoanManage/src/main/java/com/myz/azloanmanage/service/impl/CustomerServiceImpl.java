package com.myz.azloanmanage.service.impl;

import com.myz.azloanmanage.entity.Customer;
import com.myz.azloanmanage.mapper.CustomerMapper;
import com.myz.azloanmanage.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客户信息 服务实现类
 * </p>
 *
 * @author myz.azloanmanage
 * @since 2022-05-22
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

}
