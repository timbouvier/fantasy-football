package com.tbouvier.fantasyfootball.server.api;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by bouviti on 6/20/18.
 */
public class FootballPlayer extends Player {

    enum Position {
        BASE_POSITION,
        QB,
        RB,
        WR,
        TE,
        K,
        DEF
    };

    @NotEmpty
    private String team;

    @NotEmpty
    private Position position;

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
