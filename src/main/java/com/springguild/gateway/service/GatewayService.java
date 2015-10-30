package com.springguild.gateway.service;

import com.springguild.gateway.client.response.*;
import com.springguild.gateway.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;
import org.springframework.web.context.request.async.*;
import rx.Observable;

import java.util.*;
import java.util.stream.*;

/**
 * Created by jamesliljenquist on 10/29/15.
 */
@Service
public class GatewayService {

	@Autowired
	private UserService userService;

	@Autowired
	private RecipeService recipeService;


	// Create a resttemplate instance
	private RestTemplate restTemplate = new RestTemplate();

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

//		Observable<List<RecipeResponse>> suggestedRecipes = Observable.zip(
//			userService.getUserObservable(userId),
//			recipeService.getAllRecipesObservable(),
//
//			(userResponse, recipeResponses) -> {
//
//				List<RecipeResponse> recipes = recipeResponses
//					.stream()
//					.filter(recipeResponse -> userResponse.isLikesPie() == recipeResponse.isPie())
//					.collect(Collectors.toList());
//
//				return recipes;
//			}
//		);

		return suggestedRecipes;
	}
}
