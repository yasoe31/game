package com.yan.dart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yan.dart.model.Game;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

}
