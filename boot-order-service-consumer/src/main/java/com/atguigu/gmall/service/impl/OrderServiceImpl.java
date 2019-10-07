package com.atguigu.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.OrderService;
import com.atguigu.gmall.service.UserService;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Reference(loadbalance = "roundrobin")   //配置负载均衡策略
    UserService userService;

    @HystrixCommand(fallbackMethod = "hello")
    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("userId: "+userId);
        //查询用户的收获地址
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        return userAddressList;
    }

    public List<UserAddress> hello(String userId) {
        System.out.println("userId: "+userId);
        return Arrays.asList(new UserAddress(10,"测试地址","1","测试","","Y"));
    }

}
