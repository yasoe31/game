package com.yan.dart.model;

import java.util.ArrayList;
import java.util.Collection;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "game_id")
	private Long id;

	private Long creationTime;

	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name = "game_player", joinColumns = @JoinColumn(referencedColumnName = "game_id"), inverseJoinColumns = @JoinColumn(referencedColumnName = "player_id"))
	private Collection<Player> players;	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Long creationTime) {
		this.creationTime = creationTime;
	}

	public Collection<Player> getPlayer() {
		return players;
	}

	public void setPlayer(Player player) {
		if (players ==null) {
			players = new ArrayList<Player>();
		}
		
		players.add(player);
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
		return "Game [id=" + id + ", creationTime=" + creationTime
				+ ", players=" + players + "]";
	}
	

}
