package com.jwiltenburg.gamelist.services;

import com.jwiltenburg.gamelist.controllers.data.GameListResponse;
import com.jwiltenburg.gamelist.entities.GameList;
import com.jwiltenburg.gamelist.projections.GameMinProjection;
import com.jwiltenburg.gamelist.repositories.GameListRepository;
import com.jwiltenburg.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListResponse> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListResponse::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);

        list.add(destinationIndex, obj);

        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        for(int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }
}
