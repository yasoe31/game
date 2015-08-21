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

import com.yan.game.model.Player;
import com.yan.game.service.PlayerService;

@Controller
public class PlayerController {

	private static final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(PlayerController.class);

	@Autowired
	private PlayerService playerService;

	@RequestMapping(value = "/registerPlayer", method = RequestMethod.POST)
	public void registerPlayer(@RequestBody Player player) {

		LOGGER.debug("Register Player");
		playerService.registerPlayer(player);
	}

	@RequestMapping(value = "/updatePlayer", method = { RequestMethod.POST,
			RequestMethod.PUT })
	public void updatePlayer(@RequestBody Player player) {

		LOGGER.debug("Update Player");
		playerService.updatePlayer(player);
	}

	@RequestMapping(value = "/listPlayer", method = RequestMethod.GET)
	@ResponseBody
	public List<Player> listPlayer() {

		LOGGER.debug("List Player");
		return playerService.listPlayer();
	}

	@RequestMapping(value = "/deletePlayer/{id}", method = RequestMethod.DELETE)
	public void deletePlayer(@PathVariable String id) {

		LOGGER.debug("Delete Player");
		playerService.deletePlayer(Integer.parseInt(id));
	}

}
