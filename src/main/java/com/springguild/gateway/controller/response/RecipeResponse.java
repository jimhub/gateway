package com.springguild.gateway.controller.response;

import com.fasterxml.jackson.annotation.*;

/**
 * Created by jamesliljenquist on 10/29/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeResponse {

	private long id;
	private String name;
	private boolean pie;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPie() {
		return pie;
	}

	public void setPie(boolean pie) {
		this.pie = pie;
	}
}
