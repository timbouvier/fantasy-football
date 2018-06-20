package com.tbouvier.fantasyfootball.server.api;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;

/**
 * Created by bouviti on 6/20/18.
 */
public class Lineup {

    private Integer lineupId;

    @NotEmpty
    private Integer userId;

    @NotEmpty
    private Integer contestId;

    @NotEmpty
    private ArrayList<Integer> playerIds;

    public Integer getLineupId() {
        return lineupId;
    }

    public void setLineupId(Integer lineupId) {
        this.lineupId = lineupId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getContestId() {
        return contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }

    public ArrayList<Integer> getPlayerIds() {
        return playerIds;
    }

    public void setPlayerIds(ArrayList<Integer> playerIds) {
        this.playerIds = playerIds;
    }
}
