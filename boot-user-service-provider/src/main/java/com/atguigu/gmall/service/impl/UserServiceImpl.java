package com.atguigu.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Service  //dubbo暴露服务
@Component
public class UserServiceImpl implements UserService {

	@HystrixCommand
	@Override
	public List<UserAddress> getUserAddressList(String userId) {
		System.out.println("userService01...");
		// TODO Auto-generated method stub
		UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层", "1", "李老师", "010-56253825", "Y");
		UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-56253825", "N");

		if(Math.random()>0.5){
			throw new RuntimeException();
		}

		return Arrays.asList(address1,address2);
	}
}
