package com.springguild.gateway.client;

import com.springguild.gateway.client.response.*;
import org.springframework.cloud.netflix.feign.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by jamesliljenquist on 10/29/15.
 */
@FeignClient("recipes")
public interface RecipeClient {

	@RequestMapping(method = RequestMethod.GET, value = "/")
	String getHomePage();

	@RequestMapping(method = RequestMethod.GET, value = "/recipe/{id}")
	RecipeResponse getRecipe(@RequestParam("id") long id);

	@RequestMapping(method = RequestMethod.GET, value = "/recipe/")
	List<RecipeResponse> getAllRecipes();

	@RequestMapping(method = RequestMethod.GET, value = "/recipe/justPies")
	List<RecipeResponse> getPies();
}
