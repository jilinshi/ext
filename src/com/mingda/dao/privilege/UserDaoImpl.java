package com.mingda.dao.privilege;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mingda.dao.base.BaseDaoImpl;
import com.mingda.entity.Attorneyrecord;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Attorneyrecord> getAttorneyrecordByName(Attorneyrecord e) {
		String sql = "select d from Attorneyrecord d where d.mastername=:mastername";
		return this.em.createQuery(sql).setParameter("mastername", e.getMastername()).getResultList();
	}
}