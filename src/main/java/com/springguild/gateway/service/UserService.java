package com.springguild.gateway.service;

import com.netflix.hystrix.contrib.javanica.annotation.*;
import com.springguild.gateway.client.*;
import com.springguild.gateway.client.response.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

/**
 * Created by jamesliljenquist on 10/29/15.
 */
@Service
public class UserService {

	@Autowired
	private UserClient userClient;

// 	@HystrixCommand(fallbackMethod = "getFallbackUser",
////			commandProperties = {
////					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")
////			}
//	)
	public UserResponse getUser(long id) {
//		try {
//			Thread.sleep(600);
//		} catch(InterruptedException ex) {}

		return userClient.getUser(id);
	}

	public UserResponse getFallbackUser(long id) {
		UserResponse userResponse = new UserResponse();
		userResponse.setId(id);
		userResponse.setLikesPie(true);
		userResponse.setName("OH NO");

		return userResponse;
	}
}
