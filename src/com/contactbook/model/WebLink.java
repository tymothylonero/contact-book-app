package com.contactbook.model;

import java.io.Serializable;

public class WebLink implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String url;
	
	public WebLink(String name, String url) {
		this.name = name;
		this.url = url;
	}
	
	public WebLink() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return name + ":\n" + url;
	}
	
}