package com.yan.dart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Number {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="number_id")
	private Long id;
	private int twenty;
	private int nineteen;
	private int eighteen;
	private int seventeen;
	private int sixteen;
	private int fifteen;	
	private int bullseye;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTwenty() {
		return twenty;
	}

	public void setTwenty(int twenty) {
		this.twenty = twenty;
	}

	public int getNineteen() {
		return nineteen;
	}

	public void setNineteen(int nineteen) {
		this.nineteen = nineteen;
	}

	public int getEighteen() {
		return eighteen;
	}

	public void setEighteen(int eighteen) {
		this.eighteen = eighteen;
	}

	public int getSeventeen() {
		return seventeen;
	}

	public void setSeventeen(int seventeen) {
		this.seventeen = seventeen;
	}

	public int getSixteen() {
		return sixteen;
	}

	public void setSixteen(int sixteen) {
		this.sixteen = sixteen;
	}

	public int getFifteen() {
		return fifteen;
	}

	public void setFiftenn(int fifteen) {
		this.fifteen = fifteen;
	}	

	public int getBullseye() {
		return bullseye;
	}

	public void setBullseye(int bullseye) {
		this.bullseye = bullseye;
	}		

	@Override
	public int hashCode() {
		return this.getId().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Number) {
			return this.getId().equals(((Number) obj).getId());
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Number [id=" + id + ", twenty=" + twenty + ", nineteen="
				+ nineteen + ", eighteen=" + eighteen + ", seventeen="
				+ seventeen + ", sixteen=" + sixteen + ", fifteen=" + fifteen
				+ ", bullseye=" + bullseye + "]";
	}		

}
