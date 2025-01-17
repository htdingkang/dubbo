package com.atguigu.gmall.service.impl;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.OrderService;
import com.atguigu.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        //查询用户的收获地址
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        for(UserAddress item:userAddressList){
            System.out.println(item.getUserAddress());
        }
        return userAddressList;
    }
}
