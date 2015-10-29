package com.springguild.gateway;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.netflix.eureka.*;
import org.springframework.cloud.netflix.feign.*;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
}
