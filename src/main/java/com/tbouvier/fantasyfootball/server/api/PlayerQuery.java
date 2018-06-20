package com.tbouvier.fantasyfootball.server.api;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;

/**
 * Created by bouviti on 6/20/18.
 */
public class PlayerQuery {
    @NotEmpty
    private ArrayList<Integer> playerIds;

    public ArrayList<Integer> getPlayerIds() {
        return playerIds;
    }

    public void setPlayerIds(ArrayList<Integer> playerIds) {
        this.playerIds = playerIds;
    }
}
