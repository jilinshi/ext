package com.mingda.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * The persistent class for the ATTORNEYRECORD database table.
 * 
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@NamedQuery(name = "Attorneyrecord.findAll", query = "SELECT a FROM Attorneyrecord a")
public class Attorneyrecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ATTORNEYRECORD_AID_GENERATOR", sequenceName = "SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ATTORNEYRECORD_AID_GENERATOR")
	@Column(name = "A_ID")
	private long aId;

	private String attorney;

	@Column(name = "ATTORNEY_ID")
	private String attorneyId;

	private String ckcontent;

	private String ckmonth;

	private Timestamp cktime;

	private String flag;

	private String masteridno;

	private String mastername;

	private Timestamp opertime;

	private Timestamp uploadtime;

	private String upoper;

	private String wtdanwei;

	private Timestamp wttime;

	public Attorneyrecord() {
	}

	public long getAId() {
		return this.aId;
	}

	public void setAId(long aId) {
		this.aId = aId;
	}

	public String getAttorney() {
		return this.attorney;
	}

	public void setAttorney(String attorney) {
		this.attorney = attorney;
	}

	public String getAttorneyId() {
		return this.attorneyId;
	}

	public void setAttorneyId(String attorneyId) {
		this.attorneyId = attorneyId;
	}

	public String getCkcontent() {
		return this.ckcontent;
	}

	public void setCkcontent(String ckcontent) {
		this.ckcontent = ckcontent;
	}

	public String getCkmonth() {
		return this.ckmonth;
	}

	public void setCkmonth(String ckmonth) {
		this.ckmonth = ckmonth;
	}

	public Timestamp getCktime() {
		return this.cktime;
	}

	public void setCktime(Timestamp cktime) {
		this.cktime = cktime;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getMasteridno() {
		return this.masteridno;
	}

	public void setMasteridno(String masteridno) {
		this.masteridno = masteridno;
	}

	public String getMastername() {
		return this.mastername;
	}

	public void setMastername(String mastername) {
		this.mastername = mastername;
	}

	public Timestamp getOpertime() {
		return this.opertime;
	}

	public void setOpertime(Timestamp opertime) {
		this.opertime = opertime;
	}

	public Timestamp getUploadtime() {
		return this.uploadtime;
	}

	public void setUploadtime(Timestamp uploadtime) {
		this.uploadtime = uploadtime;
	}

	public String getUpoper() {
		return this.upoper;
	}

	public void setUpoper(String upoper) {
		this.upoper = upoper;
	}

	public String getWtdanwei() {
		return this.wtdanwei;
	}

	public void setWtdanwei(String wtdanwei) {
		this.wtdanwei = wtdanwei;
	}

	public Timestamp getWttime() {
		return this.wttime;
	}

	public void setWttime(Timestamp wttime) {
		this.wttime = wttime;
	}

}