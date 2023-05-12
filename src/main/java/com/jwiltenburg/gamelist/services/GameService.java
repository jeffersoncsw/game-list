package com.jwiltenburg.gamelist.services;

import com.jwiltenburg.gamelist.controllers.data.GameMinResponse;
import com.jwiltenburg.gamelist.controllers.data.GameResponse;
import com.jwiltenburg.gamelist.entities.Game;
import com.jwiltenburg.gamelist.exceptions.GameNotFoundException;
import com.jwiltenburg.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinResponse> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(game -> new GameMinResponse(game)).toList();
    }

    @Transactional(readOnly = true)
    public GameResponse findById(Long gameId){
        Game result = gameRepository.findById(gameId).orElseThrow(() -> new GameNotFoundException("Jogo não encontrado na lista"));
        return new GameResponse(result);
    }

}
