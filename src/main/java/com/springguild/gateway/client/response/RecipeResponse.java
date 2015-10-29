package com.springguild.gateway.client.response;

import com.fasterxml.jackson.annotation.*;

/**
 * Created by jamesliljenquist on 10/29/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeResponse {

	private long id;
	private String name;
	private boolean pie;
	private int applicationPort;

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

	public int getApplicationPort() {
		return applicationPort;
	}

	public void setApplicationPort(int applicationPort) {
		this.applicationPort = applicationPort;
	}
}
