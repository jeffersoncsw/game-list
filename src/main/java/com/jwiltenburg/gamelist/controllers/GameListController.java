package com.jwiltenburg.gamelist.controllers;

import com.jwiltenburg.gamelist.controllers.data.GameListResponse;
import com.jwiltenburg.gamelist.controllers.data.GameMinResponse;
import com.jwiltenburg.gamelist.controllers.data.ReplacementRequest;
import com.jwiltenburg.gamelist.services.GameListService;
import com.jwiltenburg.gamelist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListResponse> findAll() {
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinResponse> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementRequest request){
        gameListService.move(listId, request.getSourceIndex(), request.getDestinationIndex());
    }

}
