package com.springguild.gateway.service;

import com.springguild.gateway.client.*;
import com.springguild.gateway.client.response.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

/**
 * Created by jamesliljenquist on 10/29/15.
 */
@Service
public class RecipeService {

	@Autowired
	private RecipeClient recipeClient;

	public List<RecipeResponse> getAllRecipes() {
		return recipeClient.getAllRecipes();
	}


}
