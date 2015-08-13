package com.mingda.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the H_RES_INSURANCE database table.
 * 
 */
@Entity
@Table(name="H_RES_INSURANCE")
@NamedQuery(name="HResInsurance.findAll", query="SELECT h FROM HResInsurance h")
public class HResInsurance implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HResInsurancePK id;

	@Column(length=256)
	private String birthday;

	@Column(length=256)
	private String danwei;

	@Column(name="FILE_ID", length=256)
	private String fileId;

	@Column(length=256)
	private String idno;

	@Column(length=256)
	private String inno;

	@Column(name="JF_BEGIN", length=256)
	private String jfBegin;

	@Column(name="LQ_BEGIN", length=256)
	private String lqBegin;

	@Column(name="LQ_MONEY", length=256)
	private String lqMoney;

	@Column(length=256)
	private String pname;

	public HResInsurance() {
	}

	public HResInsurancePK getId() {
		return this.id;
	}

	public void setId(HResInsurancePK id) {
		this.id = id;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getDanwei() {
		return this.danwei;
	}

	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}

	public String getFileId() {
		return this.fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getIdno() {
		return this.idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public String getInno() {
		return this.inno;
	}

	public void setInno(String inno) {
		this.inno = inno;
	}

	public String getJfBegin() {
		return this.jfBegin;
	}

	public void setJfBegin(String jfBegin) {
		this.jfBegin = jfBegin;
	}

	public String getLqBegin() {
		return this.lqBegin;
	}

	public void setLqBegin(String lqBegin) {
		this.lqBegin = lqBegin;
	}

	public String getLqMoney() {
		return this.lqMoney;
	}

	public void setLqMoney(String lqMoney) {
		this.lqMoney = lqMoney;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

}