package com.springguild.gateway.service;

import com.netflix.hystrix.contrib.javanica.annotation.*;
import com.netflix.hystrix.contrib.javanica.command.*;
import com.springguild.gateway.client.*;
import com.springguild.gateway.client.response.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import rx.Observable;

/**
 * Created by jamesliljenquist on 10/29/15.
 */
@Service
public class UserService {

	@Autowired
	private UserClient userClient;

 	//@HystrixCommand(fallbackMethod = "getFallbackUser")
 	public Observable<UserResponse> getUserObservable(final long id) {
		return new ObservableResult<UserResponse>() {

			@Override
			public UserResponse invoke() {
				return userClient.getUser(id);
			}
		};
	}

	//@HystrixCommand(fallbackMethod = "getFallbackUser")
	public UserResponse getUser(long id) {
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
