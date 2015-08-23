package com.yan.game.service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;

import com.yan.game.model.Game;
import com.yan.game.model.Player;
import com.yan.game.repository.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private PlayerService playerService;
	

	private static final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(GameService.class);

	public Game createGame() {

		Game game = new Game();
		game.setCreationTime(System.currentTimeMillis());

		return gameRepository.save(game);
	}

	public void deleteGame(int id) {

		gameRepository.delete(id);
	}
	
	public Game createGamePlayer(Game game){
		
		
		
		return game;
	}

	public Game getAGame(int id) {

		return gameRepository.findOne(id);

	}

}
