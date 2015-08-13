package com.mingda.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the H_RES_INSURANCE database table.
 * 
 */
@Embeddable
public class HResInsurancePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="IN_ID", unique=true, nullable=false, precision=12)
	private long inId;

	@Column(unique=true, nullable=false, length=256)
	private String hsubject;

	public HResInsurancePK() {
	}
	public long getInId() {
		return this.inId;
	}
	public void setInId(long inId) {
		this.inId = inId;
	}
	public String getHsubject() {
		return this.hsubject;
	}
	public void setHsubject(String hsubject) {
		this.hsubject = hsubject;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HResInsurancePK)) {
			return false;
		}
		HResInsurancePK castOther = (HResInsurancePK)other;
		return 
			(this.inId == castOther.inId)
			&& this.hsubject.equals(castOther.hsubject);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.inId ^ (this.inId >>> 32)));
		hash = hash * prime + this.hsubject.hashCode();
		
		return hash;
	}
}