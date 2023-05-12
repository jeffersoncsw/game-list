package com.jwiltenburg.gamelist.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_game_list")
public class GameList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_game_list", nullable = false)
    private String name;

    public GameList() {
    }

    public GameList(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameList)) return false;
        GameList gameList = (GameList) o;
        return getId().equals(gameList.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
