package com.yan.dart.service;

import java.io.IOException;
import java.util.List;

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
import com.yan.dart.repository.GameRepository;
import com.yan.dart.repository.PlayerRepository;

@Service
public class GameService {

	@Autowired
	GameRepository gameRepository;

	@Autowired
	PlayerRepository playerRepository;

	private static final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(GameService.class);

	public Game save(String string) {

		LOGGER.debug("inside Saving Game method");

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

		Game game = objectMapper.convertValue(jsonNode.get("game"), Game.class);

		if (jsonNode.path("players").path("player").isArray()) {
			for (final JsonNode objNode : jsonNode.path("players").path(
					"player")) {

				LOGGER.debug("Setting Players through Game");
				game.setPlayer(objectMapper.convertValue(objNode, Player.class));
			}
		}

		if (game.getCreationTime() == null) {
			game.setCreationTime(System.currentTimeMillis());
		}

		return gameRepository.save(game);
	}

	public Game updateScore(String string) {

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

		Game game = objectMapper.convertValue(jsonNode.get("game"), Game.class);

		Player player = objectMapper.convertValue(jsonNode.get("player"),
				Player.class);

		Number number = objectMapper.convertValue(jsonNode.get("number"),
				Number.class);

		Game g = gameRepository.findOne(game.getId());

		List<Player> listPlayer = (List<Player>) g.getPlayer();

		for (Player player2 : listPlayer) {
			if (player2.getId() == player.getId()) {

				player2.setNumber(number);

			}

			game.setPlayer(player2);
		}

		Game temp = gameRepository.save(game);

		updateOtherPlayerPoint(temp, player);

		return temp;
	}

	public Game getAGame(Long id) {
		return gameRepository.findOne(id);
	}

	public void updateOtherPlayerPoint(Game game, Player player) {

		Player currentPlayer = playerRepository.findOne(player.getId());

		List<Player> listPlayers = (List<Player>) game.getPlayer();
		int pointToAdd = 0;
		Boolean win = true;

		for (Player otherPlayer : listPlayers) {
			pointToAdd = 0;

			if (otherPlayer.getId() != currentPlayer.getId()) {

				// pointToAdd = otherPlayer.getPoint();

				if (currentPlayer.getNumber().getBullseye() > 3) {

					if (otherPlayer.getNumber() == null
							|| otherPlayer.getNumber().getBullseye() < 3) {

						for (int i = 3; i < currentPlayer.getNumber()
								.getBullseye(); i++) {
							pointToAdd += 25;
						}

						otherPlayer.setPoint(pointToAdd);
					}
					win = (win && true);
				} else if (currentPlayer.getNumber().getBullseye() >= 3) {
					win = (win && true);

				} else {
					win = win && false;
				}

				if (currentPlayer.getNumber().getTwenty() > 3) {
					if (otherPlayer.getNumber() == null
							|| otherPlayer.getNumber().getTwenty() < 3) {

						for (int i = 3; i < currentPlayer.getNumber()
								.getTwenty(); i++) {
							pointToAdd += 20;
						}

						otherPlayer.setPoint(pointToAdd);
					}
					win = (win && true);

				} else if (currentPlayer.getNumber().getTwenty() >= 3) {
					win = (win && true);

				} else {
					win = win && false;
				}

				if (currentPlayer.getNumber().getNineteen() > 3) {
					if (otherPlayer.getNumber() == null
							|| otherPlayer.getNumber().getNineteen() < 3) {

						for (int i = 3; i < currentPlayer.getNumber()
								.getNineteen(); i++) {
							pointToAdd += 19;
						}

						otherPlayer.setPoint(pointToAdd);
					}
					win = (win && true);
				} else if (currentPlayer.getNumber().getNineteen() >= 3) {
					win = (win && true);

				} else {
					win = win && false;
				}

				if (currentPlayer.getNumber().getEighteen() > 3) {
					if (otherPlayer.getNumber() == null
							|| otherPlayer.getNumber().getEighteen() < 3) {

						for (int i = 3; i < currentPlayer.getNumber()
								.getEighteen(); i++) {
							pointToAdd += 18;
						}

						otherPlayer.setPoint(pointToAdd);
					}
					win = (win && true);
				} else if (currentPlayer.getNumber().getEighteen() >= 3) {
					win = (win && true);

				} else {
					win = win && false;
				}

				if (currentPlayer.getNumber().getSeventeen() > 3) {
					if (otherPlayer.getNumber() == null
							|| otherPlayer.getNumber().getSeventeen() < 3) {

						for (int i = 3; i < currentPlayer.getNumber()
								.getSeventeen(); i++) {
							pointToAdd += 17;
						}

						otherPlayer.setPoint(pointToAdd);
					}
					win = (win && true);
				} else if (currentPlayer.getNumber().getSeventeen() >= 3) {
					win = (win && true);

				} else {
					win = win && false;
				}

				if (currentPlayer.getNumber().getSixteen() > 3) {
					if (otherPlayer.getNumber() == null
							|| otherPlayer.getNumber().getSixteen() < 3) {

						for (int i = 3; i < currentPlayer.getNumber()
								.getSixteen(); i++) {
							pointToAdd += 16;
						}

						otherPlayer.setPoint(pointToAdd);
					}
					win = (win && true);
				} else if (currentPlayer.getNumber().getSixteen() >= 3) {
					win = (win && true);

				} else {
					win = win && false;
				}

				if (currentPlayer.getNumber().getFifteen() > 3) {
					if (otherPlayer.getNumber() == null
							|| otherPlayer.getNumber().getFifteen() < 3) {

						for (int i = 3; i < currentPlayer.getNumber()
								.getFifteen(); i++) {
							pointToAdd += 15;
						}

						otherPlayer.setPoint(pointToAdd);
						// otherPlayer.setWin(false);
					}
					win = (win && true);
				} else if (currentPlayer.getNumber().getFifteen() >= 3) {
					win = (win && true);

				} else {
					win = win && false;
				}

				if (win && (otherPlayer.getPoint() >= currentPlayer.getPoint())) {
					for (Player oPlayer : listPlayers) {
						if (oPlayer.getId() == currentPlayer.getId()) {
							oPlayer.setWin(win);
						}
					}
				} else {
					for (Player oPlayer : listPlayers) {
						if (oPlayer.getId() == currentPlayer.getId()) {
							oPlayer.setWin(win
									&& (otherPlayer.getPoint() > currentPlayer
											.getPoint()));
						}
					}
				}

			}

		}

		gameRepository.save(game);

	}

}
