package com.mingda.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the CK_BASEINFOS database table.
 * 
 */
@Entity
@Table(name = "CK_BASEINFOS")
@NamedQuery(name = "CkBaseinfo.findAll", query = "SELECT c FROM CkBaseinfo c")
public class CkBaseinfo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private BigDecimal cck;

	@Temporal(TemporalType.DATE)
	private Date ctime;

	@Column(length = 1)
	private String ds;

	@Column(length = 50)
	private String famid;

	@Column(name = "FM_ADDRESS", length = 200)
	private String fmAddress;

	@Column(name = "FM_RELMASTER", length = 20)
	private String fmRelmaster;

	@Column(length = 4000)
	private String id15;

	@Column(length = 4000)
	private String id18;

	@Column(length = 20)
	private String idno;

	@Column(length = 256)
	private String info;

	@Column(length = 20)
	private String masteridno;

	@Column(length = 50)
	private String mastername;

	@Column(name = "PI_ID", length = 51)
	private String piId;

	@Column(length = 50)
	private String pname;

	@Column(length = 20)
	private String s1;

	@Column(length = 20)
	private String s2;

	@Column(length = 20)
	private String s3;

	@Column(length = 20)
	private String s4;

	@Column(length = 6)
	private String s5;

	@Column(length = 98)
	private String salno;

	public CkBaseinfo() {
	}

	public BigDecimal getCck() {
		return this.cck;
	}

	public void setCck(BigDecimal cck) {
		this.cck = cck;
	}

	public Date getCtime() {
		return this.ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public String getDs() {
		return this.ds;
	}

	public void setDs(String ds) {
		this.ds = ds;
	}

	public String getFamid() {
		return this.famid;
	}

	public void setFamid(String famid) {
		this.famid = famid;
	}

	public String getFmAddress() {
		return this.fmAddress;
	}

	public void setFmAddress(String fmAddress) {
		this.fmAddress = fmAddress;
	}

	public String getFmRelmaster() {
		return this.fmRelmaster;
	}

	public void setFmRelmaster(String fmRelmaster) {
		this.fmRelmaster = fmRelmaster;
	}

	public String getId15() {
		return this.id15;
	}

	public void setId15(String id15) {
		this.id15 = id15;
	}

	public String getId18() {
		return this.id18;
	}

	public void setId18(String id18) {
		this.id18 = id18;
	}

	public String getIdno() {
		return this.idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
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

	public String getPiId() {
		return this.piId;
	}

	public void setPiId(String piId) {
		this.piId = piId;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getS1() {
		return this.s1;
	}

	public void setS1(String s1) {
		this.s1 = s1;
	}

	public String getS2() {
		return this.s2;
	}

	public void setS2(String s2) {
		this.s2 = s2;
	}

	public String getS3() {
		return this.s3;
	}

	public void setS3(String s3) {
		this.s3 = s3;
	}

	public String getS4() {
		return this.s4;
	}

	public void setS4(String s4) {
		this.s4 = s4;
	}

	public String getS5() {
		return this.s5;
	}

	public void setS5(String s5) {
		this.s5 = s5;
	}

	public String getSalno() {
		return this.salno;
	}

	public void setSalno(String salno) {
		this.salno = salno;
	}

}