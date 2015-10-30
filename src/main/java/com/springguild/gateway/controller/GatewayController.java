package com.springguild.gateway.controller;

import com.springguild.gateway.client.response.*;
import com.springguild.gateway.service.*;
import com.springguild.gateway.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.*;

import java.util.*;

/**
 * Created by jamesliljenquist on 10/29/15.
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class GatewayController {

	@Autowired
	private GatewayService gatewayService;

	@RequestMapping("/getSuggestedRecipes")
	public List<RecipeResponse> getSuggestedRecipes(@RequestParam("userId") long userId) {
		return gatewayService.getSuggestedRecipes(userId);
	}

}
