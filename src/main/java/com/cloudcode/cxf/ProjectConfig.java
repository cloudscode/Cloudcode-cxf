package com.cloudcode.cxf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.cloudcode.cxf.model.App;
import com.cloudcode.framework.annotation.ModuleConfig;
import com.cloudcode.framework.bean.ProjectBeanNameGenerator;
import com.cloudcode.framework.dao.ModelObjectDao;
import com.cloudcode.framework.dao.impl.BaseDaoImpl;

@ModuleConfig(name = ProjectConfig.NAME, domainPackages = { "com.cloudcode.cxf.model" })
@ComponentScan(basePackages = { "com.cloudcode.cxf.*" }, nameGenerator = ProjectBeanNameGenerator.class)
@PropertySource(name = "cloudcode.evn", value = { "classpath:proj.properties" })
public class ProjectConfig {
	public static final String NAME = "cxf";
	public static final String PREFIX = NAME + ".";

	@Bean(name = PREFIX + "appDao")
	public ModelObjectDao<App> generateAppDao() {
		return new BaseDaoImpl<App>(App.class);
	}

}
