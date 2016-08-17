package com.cloudcode.cxf.cxf.impl;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.cloudcode.cxf.cxf.IAppClient;
import com.cloudcode.cxf.dao.AppDao;
import com.cloudcode.cxf.model.App;
import com.cloudcode.framework.utils.BeanFactoryHelper;

@WebService//(endpointInterface = "com.cloudcode.cxf.cxf.IAppClient", serviceName = "appClient", targetNamespace = "http://cxf.client.cloudcode.com/")
public class appClient {//implements IAppClient {

	private AppDao appDao;

	@WebMethod(exclude = true)
	public AppDao getContractDao() {
		if (appDao == null) {
			appDao = BeanFactoryHelper.getBeanFactory().getBean(
					AppDao.class);
		}
		return appDao;
	}

	//@WebMethod
	public List<App> LoadAppAll() {
		System.out.println("AppDao:=" + getContractDao());
		List<App> list = appDao.loadAppAll();

		return list;
	}

}
