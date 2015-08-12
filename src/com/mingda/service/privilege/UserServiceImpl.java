package com.mingda.service.privilege;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.ehcache.annotations.TriggersRemove;
import com.mingda.dao.privilege.UserDao;
import com.mingda.entity.Attorneyrecord;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Transactional(propagation = Propagation.REQUIRED)
	@Cacheable(value = "userCache")
	public <T> T getById(Class<T> clazz, Object id) {
		return userDao.getById(clazz, id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@TriggersRemove(cacheName = "userCache", removeAll = true)
	public void save(Object entity) {
		userDao.save(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@TriggersRemove(cacheName = "userCache", removeAll = true)
	public List<Attorneyrecord> getList(Attorneyrecord e) {
		return userDao.getAttorneyrecordByName(e);
	}
}