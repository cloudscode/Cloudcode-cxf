package com.cloudcode.cxf.mvc;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cloudcode.cxf.dao.AppDao;
import com.cloudcode.cxf.dao.Test;
import com.cloudcode.cxf.model.App;
import com.cloudcode.framework.controller.CrudController;
import com.cloudcode.framework.utils.UUID;

@Controller
@RequestMapping("/app")
public class AppController extends CrudController<App> {
	@Autowired
	private AppDao appDao;
	@Autowired
	private Test test;
	@RequestMapping(value = "/test", method = { RequestMethod.POST,
			RequestMethod.GET })
	public @ResponseBody void test(@ModelAttribute  @Valid App app, HttpServletRequest request) {
		appDao.loadAppAll();
	}
	@RequestMapping(value = "create")
	public ModelAndView create() {
		App app=new App();
		app.setId(UUID.generateUUID());
		app.setName("cloudcode");
		app.setCreateDateTime(new Date());
		test.addMenu(app);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("classpath:com/cloudcode/cxf/ftl/detail.ftl");
		return modelAndView;
	}
}
