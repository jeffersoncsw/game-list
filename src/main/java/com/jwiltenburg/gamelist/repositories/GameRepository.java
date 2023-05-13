package com.jwiltenburg.gamelist.repositories;

import com.jwiltenburg.gamelist.entities.Game;
import com.jwiltenburg.gamelist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(nativeQuery = true, value = """
            SELECT tb_game.id, tb_game.title_game AS titleGame, tb_game.year_game AS yearGame, tb_game.img_url_game AS imgUrlGame,\s
                   tb_game.short_description_game AS shortDescriptionGame, tb_belonging.position_belonging AS positionBelonging
            FROM tb_game
            INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
            WHERE tb_belonging.list_id = :listId
            ORDER BY tb_belonging.position_belonging
            """)
    List<GameMinProjection> searchByList(Long listId);
}
