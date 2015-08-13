package com.mingda.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TEMP01 database table.
 * 
 */
@Entity
@Table(name="TEMP01")
@NamedQuery(name="Temp01.findAll", query="SELECT t FROM Temp01 t")
public class Temp01 implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="\"A\"", length=256)
	private String a;

	@Column(length=256)
	private String b;

	@Column(length=256)
	private String c;

	@Column(length=256)
	private String d;

	@Column(length=256)
	private String e;

	@Column(length=256)
	private String f;

	@Column(length=256)
	private String g;

	@Column(length=256)
	private String h;

	@Column(length=256)
	private String i;

	@Column(length=256)
	private String j;

	@Column(length=256)
	private String k;

	@Column(length=256)
	private String l;

	public Temp01() {
	}

	public String getA() {
		return this.a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return this.b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return this.c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getD() {
		return this.d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public String getE() {
		return this.e;
	}

	public void setE(String e) {
		this.e = e;
	}

	public String getF() {
		return this.f;
	}

	public void setF(String f) {
		this.f = f;
	}

	public String getG() {
		return this.g;
	}

	public void setG(String g) {
		this.g = g;
	}

	public String getH() {
		return this.h;
	}

	public void setH(String h) {
		this.h = h;
	}

	public String getI() {
		return this.i;
	}

	public void setI(String i) {
		this.i = i;
	}

	public String getJ() {
		return this.j;
	}

	public void setJ(String j) {
		this.j = j;
	}

	public String getK() {
		return this.k;
	}

	public void setK(String k) {
		this.k = k;
	}

	public String getL() {
		return this.l;
	}

	public void setL(String l) {
		this.l = l;
	}

}