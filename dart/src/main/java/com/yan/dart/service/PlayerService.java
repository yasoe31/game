package com.yan.dart.service;

import java.io.IOException;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yan.dart.model.Game;
import com.yan.dart.model.Number;
import com.yan.dart.model.Player;
import com.yan.dart.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	PlayerRepository playerRepository;

	private static final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(PlayerService.class);

	public Player saveANumber(String string) {
		LOGGER.debug("inside Saving Number method");

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = null;

		try {
			jsonNode = objectMapper.readTree(string);
			LOGGER.debug("reading jsonNode");
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Player player = objectMapper.convertValue(jsonNode.get("player"),
				Player.class);

		Number number = objectMapper.convertValue(jsonNode.get("number"),
				Number.class);

		player.setNumber(number);

		return playerRepository.save(player);
	}

	public Player addANumber(String string) {

		LOGGER.debug("inside Adding Number method");

		System.out.println("--------Service-----------");

		System.out.println(string);

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = null;

		try {
			jsonNode = objectMapper.readTree(string);
			LOGGER.debug("reading jsonNode");
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Player player = objectMapper.convertValue(jsonNode.get("player"),
				Player.class);

		Number number = objectMapper.convertValue(jsonNode.get("number"),
				Number.class);

		return playerRepository.save(player);

	}	

}
