package com.mingda.dao.privilege;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.mingda.dao.base.BaseDaoImpl;
import com.mingda.dto.DistrictsDTO;
import com.mingda.entity.SysDistrict;

@Repository
public class DistrictDaoImpl extends BaseDaoImpl implements DistrictDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<DistrictsDTO> getDistrictAll() {

		List<DistrictsDTO> rlist = new ArrayList<DistrictsDTO>();

		List<SysDistrict> slist = this.em.createNamedQuery("SysDistrict.findAll").getResultList();

		slist.stream().forEach(action -> {
			DistrictsDTO d = new DistrictsDTO();
			BeanUtils.copyProperties(action, d);
			rlist.add(d);
		});

		return rlist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DistrictsDTO> getDistrictByPid(String pid) {
		List<DistrictsDTO> rlist = new ArrayList<DistrictsDTO>();

		List<SysDistrict> slist = this.em.createNamedQuery("SysDistrict.findAll").getResultList();

		slist.stream().forEach(action -> {
			DistrictsDTO d = new DistrictsDTO();
			BeanUtils.copyProperties(action, d);
			rlist.add(d);
		});

		return rlist;
	}

}
