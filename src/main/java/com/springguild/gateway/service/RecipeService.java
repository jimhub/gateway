package com.springguild.gateway.service;

import com.netflix.hystrix.contrib.javanica.command.*;
import com.springguild.gateway.client.*;
import com.springguild.gateway.client.response.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import rx.Observable;

import java.util.*;

/**
 * Created by jamesliljenquist on 10/29/15.
 */
@Service
public class RecipeService {

	@Autowired
	private RecipeClient recipeClient;

	public Observable<List<RecipeResponse>> getAllRecipesObservable() {
		return new ObservableResult<List<RecipeResponse>>() {

			@Override
			public List<RecipeResponse> invoke() {
				return recipeClient.getAllRecipes();
			}
		};
	}

	public List<RecipeResponse> getAllRecipes() {
		return recipeClient.getAllRecipes();
	}


}
