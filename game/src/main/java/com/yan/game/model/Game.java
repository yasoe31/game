package com.yan.game.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game {

	@Id
	@Column(name = "game_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private long creationTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public long getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(long creationTime) {
		this.creationTime = creationTime;
	}

	@Override
	public int hashCode() {
		return this.getId().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Game) {
			return this.getId().equals(((Game) obj).getId());
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", creationTime=" + creationTime + "]";
	}

}
