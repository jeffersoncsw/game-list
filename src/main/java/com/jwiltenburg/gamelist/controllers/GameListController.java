package com.jwiltenburg.gamelist.controllers;

import com.jwiltenburg.gamelist.controllers.data.GameListResponse;
import com.jwiltenburg.gamelist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping(value = "/lists")
    public List<GameListResponse> findAll(){
        return gameListService.findAll();
    }


}