package com.jwiltenburg.gamelist.services;

import com.jwiltenburg.gamelist.controllers.data.GameMinResponse;
import com.jwiltenburg.gamelist.entities.Game;
import com.jwiltenburg.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinResponse> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(game -> new GameMinResponse(game)).toList();
    }

}
