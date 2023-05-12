package com.jwiltenburg.gamelist.repositories;

import com.jwiltenburg.gamelist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
