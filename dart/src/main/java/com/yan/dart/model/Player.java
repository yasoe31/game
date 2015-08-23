package com.yan.dart.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="player_id")
	private Long id;
	private String name;
	private int point;
	
	@Column(columnDefinition = "TINYINT", length = 1)
	private Boolean win;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="number_id")
	private Number number;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}	

	public Number getNumber() {
		return number;
	}

	public void setNumber(Number number) {
		this.number = number;
	}	

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}	

	public Boolean getWin() {
		return win;
	}

	public void setWin(Boolean win) {
		this.win = win;
	}

	@Override
	public int hashCode() {
		return this.getId().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Player) {
			return this.getId().equals(((Player) obj).getId());
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", point=" + point
				+ ", win=" + win + ", number=" + number + "]";
	}
	
}
