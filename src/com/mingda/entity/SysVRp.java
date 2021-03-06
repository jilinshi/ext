package com.mingda.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the SYS_V_RP database table.
 * 
 */
@Entity
@Table(name="SYS_V_RP")
@NamedQuery(name="SysVRp.findAll", query="SELECT s FROM SysVRp s")
public class SysVRp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length=128)
	private String privicode;

	@Column(name="PRIVILEGE_ID", nullable=false, precision=12)
	private BigDecimal privilegeId;

	@Column(length=128)
	private String priviname;

	@Column(length=128)
	private String remark;
	@Id
	@Column(name="ROLE_ID", nullable=false, precision=12)
	private BigDecimal roleId;

	@Column(length=128)
	private String rolename;

	private Timestamp spctime;

	@Column(length=128)
	private String spflag;

	private Timestamp srctime;

	@Column(length=128)
	private String srflag;

	private Timestamp srutime;

	public SysVRp() {
	}

	public String getPrivicode() {
		return this.privicode;
	}

	public void setPrivicode(String privicode) {
		this.privicode = privicode;
	}

	public BigDecimal getPrivilegeId() {
		return this.privilegeId;
	}

	public void setPrivilegeId(BigDecimal privilegeId) {
		this.privilegeId = privilegeId;
	}

	public String getPriviname() {
		return this.priviname;
	}

	public void setPriviname(String priviname) {
		this.priviname = priviname;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getRoleId() {
		return this.roleId;
	}

	public void setRoleId(BigDecimal roleId) {
		this.roleId = roleId;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Timestamp getSpctime() {
		return this.spctime;
	}

	public void setSpctime(Timestamp spctime) {
		this.spctime = spctime;
	}

	public String getSpflag() {
		return this.spflag;
	}

	public void setSpflag(String spflag) {
		this.spflag = spflag;
	}

	public Timestamp getSrctime() {
		return this.srctime;
	}

	public void setSrctime(Timestamp srctime) {
		this.srctime = srctime;
	}

	public String getSrflag() {
		return this.srflag;
	}

	public void setSrflag(String srflag) {
		this.srflag = srflag;
	}

	public Timestamp getSrutime() {
		return this.srutime;
	}

	public void setSrutime(Timestamp srutime) {
		this.srutime = srutime;
	}

}