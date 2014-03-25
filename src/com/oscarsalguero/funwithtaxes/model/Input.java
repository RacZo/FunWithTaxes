/*
 * Copyright (C) 2014 Oscar Salguero
 * 
 */

package com.oscarsalguero.funwithtaxes.model;

import java.io.Serializable;

public class Input implements Serializable{
	
	private static final long serialVersionUID = -5858301360013743336L;
	
	private int id;
	private String name;
	
	public Input(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
