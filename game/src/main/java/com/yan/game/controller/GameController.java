package com.yan.game.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.qos.logback.classic.Logger;

import com.yan.game.model.Game;
import com.yan.game.model.Player;
import com.yan.game.service.GameService;
import com.yan.game.service.PlayerService;

@Controller
public class GameController {

	private static final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(GameController.class);

	@Autowired
	private GameService gameService;

	@Autowired
	private PlayerService playerService;

	@RequestMapping(value = "/createGame", method = RequestMethod.POST)
	@ResponseBody
	public Game createGame() {

		LOGGER.debug("Creating Game");
		return gameService.createGame();

	}

	@RequestMapping(value = "/deleteGame/{id}", method = RequestMethod.DELETE)
	public void deleteGame(@PathVariable String id) {

		LOGGER.debug("Delete Game");
		gameService.deleteGame(Integer.parseInt(id));

	}

	@RequestMapping(value = "/createGamePlayer", method = RequestMethod.POST)
	@ResponseBody
	public Game createGamePlayer(@RequestBody Game game) {

		return gameService.createGamePlayer(game);

	}

	@RequestMapping(value = "/getAGame/{id}", method = RequestMethod.GET)
	@ResponseBody
	private Game getAGame(@PathVariable String id) {

		return gameService.getAGame(Integer.parseInt(id));

	}

}
