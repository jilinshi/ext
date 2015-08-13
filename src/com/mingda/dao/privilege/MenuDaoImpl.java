package com.mingda.dao.privilege;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mingda.dao.base.BaseDaoImpl;
import com.mingda.entity.SysVUmenu;
@Repository
public class MenuDaoImpl extends BaseDaoImpl implements MenuDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<SysVUmenu> getMenuByUser(BigDecimal userId) {
		List<SysVUmenu> list = this.em.createNamedQuery("SysVUmenu.findByUser").setParameter("userId", userId)
				.setParameter("privicode", "READONLY").getResultList();
		return list;
	}

}
