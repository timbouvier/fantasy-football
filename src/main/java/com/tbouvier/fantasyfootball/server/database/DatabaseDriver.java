package com.tbouvier.fantasyfootball.server.database;

import com.tbouvier.fantasyfootball.server.api.Contest;
import com.tbouvier.fantasyfootball.server.api.Lineup;
import com.tbouvier.fantasyfootball.server.api.Player;

import java.util.ArrayList;

/**
 * Created by bouviti on 6/20/18.
 */
public interface DatabaseDriver {


    boolean connect();
    boolean disconnect();
    boolean isConnected();

    void setAddress(String address);
    void setPort(Integer port);

    //atomic fetch+increment/random hash
    Integer getNewPlayerId();
    Integer getNewContestId();
    Integer getNewLineupId();

    void insertPlayer(Player playerEntry);
    void insertContest(Contest contest);
    void insertLineup(Lineup lineup);

    Player getPlayer(Integer id);
    boolean playerExists(String name);
    ArrayList<Player> getPlayers();

    Contest getContest(Integer id);
    ArrayList<Contest> getContests();

    Lineup getLineup(Integer lineupId);
    ArrayList<Lineup> getLineups();
    ArrayList<Lineup> getLineups(Integer contestId);
}
