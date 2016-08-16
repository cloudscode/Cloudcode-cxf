package com.cloudcode.cxf.cxf;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.cloudcode.cxf.model.App;

@WebService
public interface IAppClient {
	@WebMethod
	public List<App> LoadAppAll();
}
