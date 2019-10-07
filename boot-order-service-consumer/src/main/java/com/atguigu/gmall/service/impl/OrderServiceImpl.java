package com.atguigu.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.OrderService;
import com.atguigu.gmall.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Reference(url="127.0.0.1:20880")  //依赖的远程接口，声明服务代理  //dubbo直连
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("userId: "+userId);
        //查询用户的收获地址
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        return userAddressList;
    }
}
