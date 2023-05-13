package com.jwiltenburg.gamelist.projections;

public interface GameMinProjection {

    Long getId();
    String getTitleGame();
    Integer getYearGame();
    String getImgUrlGame();
    String getShortDescriptionGame();
}
