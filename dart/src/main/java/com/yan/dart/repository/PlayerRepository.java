package com.yan.dart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yan.dart.model.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

}
