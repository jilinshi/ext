package com.mingda.dao.privilege;

import java.util.List;

import com.mingda.dao.base.BaseDao;
import com.mingda.dto.DistrictsDTO;

public interface DistrictDao extends BaseDao {
	public List<DistrictsDTO> getDistrictAll();

	public List<DistrictsDTO> getDistrictByPid(String pid);
}
