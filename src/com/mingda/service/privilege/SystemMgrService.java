package com.mingda.service.privilege;

import java.math.BigDecimal;
import java.util.List;

import com.mingda.dto.DistrictsDTO;
import com.mingda.entity.SysVUmenu;
import com.mingda.service.base.BaseService;

public interface SystemMgrService extends BaseService {
	public List<SysVUmenu> getMenuByUser(BigDecimal userId);

	public List<DistrictsDTO> getDistrict();

	public List<DistrictsDTO> getDistrictByPid(String pid);
}
