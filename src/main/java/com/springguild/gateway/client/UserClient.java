package com.springguild.gateway.client;

import com.springguild.gateway.client.response.*;
import org.springframework.cloud.netflix.feign.*;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jamesliljenquist on 10/29/15.
 */
@FeignClient("users")
public interface UserClient {

	@RequestMapping(method = RequestMethod.GET, value = "/")
	String getHomePage();

	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	UserResponse getUser(@RequestParam("id") long id);

}
