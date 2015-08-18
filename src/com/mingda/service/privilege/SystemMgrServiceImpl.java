package com.mingda.service.privilege;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mingda.dao.privilege.DistrictDao;
import com.mingda.dao.privilege.MenuDao;
import com.mingda.dto.DistrictsDTO;
import com.mingda.entity.SysVUmenu;

@Service
public class SystemMgrServiceImpl implements SystemMgrService {

	@Autowired
	private MenuDao menuDao;
	@Autowired
	private DistrictDao districtDao;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void save(Object entity) {
		menuDao.save(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public <T> T getById(Class<T> clazz, Object id) {
		return menuDao.getById(clazz, id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Cacheable(value = "userCache")
	@Override
	public List<SysVUmenu> getMenuByUser(BigDecimal userId) {
		return menuDao.getMenuByUser(userId);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Cacheable(value = "userCache")
	@Override
	public List<DistrictsDTO> getDistrict() {

		return districtDao.getDistrictAll();
	}
	@Transactional(propagation = Propagation.REQUIRED)
	@Cacheable(value = "userCache")
	@Override
	public List<DistrictsDTO> getDistrictByPid(String pid) {

		return districtDao.getDistrictByPid(pid);
	}
}
