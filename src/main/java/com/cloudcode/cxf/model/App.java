package com.cloudcode.cxf.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.cloudcode.framework.model.BaseModelObject;
@Document(collection = "App")
public class App extends BaseModelObject {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
