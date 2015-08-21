package com.yan.game.model;

import javax.persistence.Entity;

@Entity
public class Player {

	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
