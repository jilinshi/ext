package com.mingda.dao.privilege;

import java.util.List;

import com.mingda.dao.base.BaseDao;
import com.mingda.entity.Attorneyrecord;

public interface UserDao extends BaseDao{

	public List<Attorneyrecord> getAttorneyrecordByName(Attorneyrecord e);
}