package com.jwiltenburg.gamelist.repositories;

import com.jwiltenburg.gamelist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
