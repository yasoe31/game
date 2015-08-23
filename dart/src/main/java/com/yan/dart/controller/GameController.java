package com.yan.dart.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.qos.logback.classic.Logger;

import com.yan.dart.model.Game;
import com.yan.dart.service.GameService;

@Controller
public class GameController {

	private static final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(GameController.class);

	@Autowired
	GameService gameService;

	@RequestMapping(value = "/createGamePlayer", method = RequestMethod.POST)
	@ResponseBody
	private Game createGamePlayer(@RequestBody String string) {

		LOGGER.debug("Saving a Game");
		return gameService.save(string);
	}

	@RequestMapping(value = "/updateScore", method = RequestMethod.POST)
	@ResponseBody
	private Game updateScore(@RequestBody String string) {

		return gameService.updateScore(string);

	}
	
	@RequestMapping(value="/getAGame/{id}",method=RequestMethod.GET)
	@ResponseBody
	private Game gatAGame(@PathVariable String id) {
		
		
		return gameService.getAGame(Long.parseLong(id));
	}

}
