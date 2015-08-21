package com.yan.game.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yan.game.model.Game;
import com.yan.game.repository.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;

	public void createGame(Game game) {

		gameRepository.save(game);
	}

	public void deleteGame(int id) {

		gameRepository.delete(id);
	}

}
