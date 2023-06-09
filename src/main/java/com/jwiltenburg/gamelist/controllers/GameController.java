package com.jwiltenburg.gamelist.controllers;

import com.jwiltenburg.gamelist.controllers.data.GameMinResponse;
import com.jwiltenburg.gamelist.controllers.data.GameResponse;
import com.jwiltenburg.gamelist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinResponse> findAll(){
        return gameService.findAll();
    }

    @GetMapping(value = "/{gameId}")
    public GameResponse findById(@PathVariable Long gameId){
        return gameService.findById(gameId);
    }

}
