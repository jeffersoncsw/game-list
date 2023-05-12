package com.jwiltenburg.gamelist.services;

import com.jwiltenburg.gamelist.controllers.data.GameListResponse;
import com.jwiltenburg.gamelist.entities.GameList;
import com.jwiltenburg.gamelist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListResponse> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListResponse::new).toList();
    }
}
