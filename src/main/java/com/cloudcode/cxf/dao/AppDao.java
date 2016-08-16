package com.cloudcode.cxf.dao;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cloudcode.cxf.ProjectConfig;
import com.cloudcode.cxf.model.App;
import com.cloudcode.framework.dao.BaseModelObjectDao;
import com.cloudcode.framework.dao.ModelObjectDao;
import com.cloudcode.framework.utils.UUID;

@Repository
@Transactional
public class AppDao extends BaseModelObjectDao<App> {
	
	//@Autowired  
	//private RedisTemplate redisTemplate;
	
	@Resource(name = ProjectConfig.PREFIX + "appDao")
	private ModelObjectDao<App> appDao;
	
	public void addMenu(App entity) {
		if(null != entity.getId() && "".equals(entity.getId())){
			entity.setId(UUID.generateUUID());
		}
		appDao.createObject(entity);
	}
	
}
