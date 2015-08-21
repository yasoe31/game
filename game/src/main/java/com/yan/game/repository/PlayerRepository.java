package com.yan.game.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yan.game.model.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {

}
