package com.jwiltenburg.gamelist.controllers.data;

import com.jwiltenburg.gamelist.entities.GameList;

public class GameListResponse {

    private Long id;
    private String name;

    public GameListResponse() {
    }

    public GameListResponse(GameList entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
