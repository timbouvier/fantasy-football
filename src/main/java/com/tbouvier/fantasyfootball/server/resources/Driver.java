package com.tbouvier.fantasyfootball.server.resources;

import com.tbouvier.fantasyfootball.server.api.*;

import java.util.ArrayList;

/**
 * Created by bouviti on 6/20/18.
 */
public interface Driver {

    ArrayList<Contest> getContests(boolean showLineups);
    Contest getContest(Integer id, boolean showLineups);
    ArrayList<Lineup> getLineups();
    Lineup getLineups(Integer lineupId);
    PlayerResponse getPlayers(PlayerQuery query);
    void createContest(Contest contest);
    void addLineup(Lineup lineup);
    void addPlayer(Player player);

}
