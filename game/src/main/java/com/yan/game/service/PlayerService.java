package com.yan.game.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yan.game.model.Player;
import com.yan.game.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	public Player registerPlayer(Player player) {

		return playerRepository.save(player);
	}

	public void updatePlayer(Player player) {

		Player p = playerRepository.findOne(player.getId());
		p.setName(player.getName());
		playerRepository.save(p);
	}

	public List<Player> listPlayer() {

		return (List<Player>) playerRepository.findAll();
	}

	public void deletePlayer(int id) {

		playerRepository.delete(id);
	}

}
