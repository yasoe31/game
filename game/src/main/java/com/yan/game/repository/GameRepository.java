package com.yan.game.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yan.game.model.Game;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {

}
