package com.mingda.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the MV_MASTER_LQM database table.
 * 
 */
@Entity
@Table(name="MV_MASTER_LQM")
@NamedQuery(name="MvMasterLqm.findAll", query="SELECT m FROM MvMasterLqm m")
public class MvMasterLqm implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(length=20)
	private String masterid;

	@Column(name="SUM_LQ_MONEY")
	private BigDecimal sumLqMoney;

	public MvMasterLqm() {
	}

	public String getMasterid() {
		return this.masterid;
	}

	public void setMasterid(String masterid) {
		this.masterid = masterid;
	}

	public BigDecimal getSumLqMoney() {
		return this.sumLqMoney;
	}

	public void setSumLqMoney(BigDecimal sumLqMoney) {
		this.sumLqMoney = sumLqMoney;
	}

}