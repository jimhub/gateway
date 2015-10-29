package com.springguild.gateway.client.response;

import com.fasterxml.jackson.annotation.*;

/**
 * Created by jamesliljenquist on 10/29/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {

	private long id;
	private String name;
	private boolean likesPie;

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

	public boolean isLikesPie() {
		return likesPie;
	}

	public void setLikesPie(boolean likesPie) {
		this.likesPie = likesPie;
	}
}
