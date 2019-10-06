package com.atguigu.gmall.config;

import com.alibaba.dubbo.config.*;
import com.atguigu.gmall.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyDubboConfig {
    //<dubbo:application name="userserviceprovider_boot"></dubbo:application>
    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig=new ApplicationConfig();
        applicationConfig.setName("userserviceprovider_boot03");
        return applicationConfig;
    }
    //<dubbo:registry address="zookeeper://127.0.0.1:2181"></dubbo:registry>
    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig=new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("127.0.0.1:2181");
        return registryConfig;
    }
    //<dubbo:protocol name="dubbo" port="20880"></dubbo:protocol>
    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        return protocolConfig;
    }
//    <dubbo:service interface="com.atguigu.gmall.service.UserService"ref="userServiceImpl" version="1.0.0">
//        <dubbo:method name="getUserAddressList" timeout="2000"></dubbo:method>
//    </dubbo:service>
@   Bean
    public ServiceConfig<UserService>  serviceConfig(UserService userService){
        ServiceConfig<UserService> serviceConfig=new ServiceConfig();
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(userService);
        serviceConfig.setVersion("1.0.0");

        List<MethodConfig> methods=new ArrayList();

        //配置每一个Method信息
        MethodConfig methodConfig=new MethodConfig();
        methodConfig.setName("getUserAddressList");
        methodConfig.setTimeout(3000);

        methods.add(methodConfig);

        serviceConfig.setMethods(methods);
        return serviceConfig;
    }



}
