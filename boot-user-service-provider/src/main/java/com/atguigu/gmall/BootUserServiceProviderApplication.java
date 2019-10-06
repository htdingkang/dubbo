package com.atguigu.gmall;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//@EnableDubbo   //开启基于注解的dubbo功能，指定要扫描的包，也可以在application.properties中配置 dubbo.scan.base-packages=XXX
//@ImportResource(locations = "classpath:provider.xml")
@DubboComponentScan(basePackages = "com.atguigu.gmall")
@SpringBootApplication
public class BootUserServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootUserServiceProviderApplication.class, args);
    }

}
