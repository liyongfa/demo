package com.gdut.configclient.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.serviceregistry.ServiceRegistry;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: lyf
 * @Date: 2019-07-12 15:12
 * @Description:
 */
@Configuration
//@EnableDiscoveryClient(autoRegister = false)
public class MyConfiguration {

    private ServiceRegistry registry;

    public MyConfiguration(ServiceRegistry registry) {
        this.registry = registry;
    }

    public void registry() {
        registry = new EurekaServiceRegistry();
    }

    //启用了负载均衡的功能
    @Bean
    @LoadBalanced
    RestTemplate initRestTemplate() {
        return new RestTemplate();
    }
}
