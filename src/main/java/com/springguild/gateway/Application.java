package com.springguild.gateway;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.netflix.eureka.*;
import org.springframework.cloud.netflix.feign.*;
import org.springframework.cloud.netflix.hystrix.*;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
}
