package com.yan.game.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {

	@Id
	@Column(name = "player_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + "]";
	}

}
