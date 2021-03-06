package com.yan.game.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Game {

	@Id
	@Column(name = "game_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private long creationTime;

	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name = "game_player", 
				joinColumns = @JoinColumn(referencedColumnName = "game_id"), 
				inverseJoinColumns = @JoinColumn(referencedColumnName = "player_id"))
	private List<Player> players;

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

	public Collection<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> listPlayers) {

		if (this.players == null) {
			players = new ArrayList<Player>();
		}
		players = listPlayers;
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
