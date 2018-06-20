package com.tbouvier.fantasyfootball.server.api;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;

/**
 * Created by bouviti on 6/20/18.
 */
public class PlayerResponse {

    @NotEmpty
    private ArrayList<Player> players;

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
