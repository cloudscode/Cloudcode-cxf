/**
 * Project Name:Cloudcode-cxf
 * File Name:Test.java
 * Package Name:com.cloudcode.cxf.dao
 * Date:2016-8-18下午5:05:34
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.cloudcode.cxf.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.cloudcode.cxf.model.App;
import com.cloudcode.framework.dao.mongo.impl.BaseMongoDAOImpl;

@Repository
public class Test extends BaseMongoDAOImpl<App> {

	protected void setMongoTemplate(MongoTemplate mongoTemplate) {
		if (!mongoTemplate.collectionExists(App.class)) {
			mongoTemplate.createCollection(App.class);
		}	
		this.mongoTemplate =mongoTemplate;
	}
	@Autowired
	private MongoTemplate mongoTemplate2;
	public void addMenu(App entity) {
		setMongoTemplate( mongoTemplate2);
		this.save(entity);
	}
}

