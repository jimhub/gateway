package com.springguild.gateway.controller;

import com.springguild.gateway.controller.response.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;

import java.util.*;

/**
 * Created by jamesliljenquist on 10/29/15.
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class GatewayController {

	private RestTemplate restTemplate = new RestTemplate();

	@RequestMapping("/getSuggestedRecipes")
	public List<RecipeResponse> getSuggestedRecipes(@RequestParam("userId") long userId) {

		List<RecipeResponse> suggestedRecipes = new ArrayList<RecipeResponse>();

		// Get the user's info from the users service
		UserResponse userResponse = restTemplate.getForObject("http://localhost:8981/user/{userId}", UserResponse.class, userId);

		// Get all recipes from the recipe service
		RecipeResponse[] recipeResponses = restTemplate.getForObject("http://localhost:8982/recipe/", RecipeResponse[].class);

		// Build list of suggested recipes based on user's pie preference
		for(RecipeResponse recipeResponse : recipeResponses) {
			if(userResponse.isLikesPie() == recipeResponse.isPie()) {
				suggestedRecipes.add(recipeResponse);
			}
		}

		return suggestedRecipes;
	}

}
