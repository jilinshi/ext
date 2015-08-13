package com.mingda.dao.privilege;

import java.math.BigDecimal;
import java.util.List;

import com.mingda.dao.base.BaseDao;
import com.mingda.entity.SysVUmenu;

public interface MenuDao extends BaseDao {
	public List<SysVUmenu> getMenuByUser(BigDecimal userId);
}
