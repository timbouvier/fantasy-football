package com.tbouvier.fantasyfootball.server.resources;

import com.google.inject.Inject;
import com.tbouvier.fantasyfootball.server.api.*;
import com.tbouvier.fantasyfootball.server.database.DatabaseDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Created by bouviti on 6/20/18.
 *
 * use this class to apply and additional logic needed for
 * database inserts/removals/retrievals
 *
 * **TODO: implement cache
 */
public class FantasyFootballAppDriver implements Driver{

    private DatabaseDriver databaseDriver;
    private Logger LOGGER = LoggerFactory.getLogger(FantasyFootballAppDriver.class);

    @Inject
    public FantasyFootballAppDriver(DatabaseDriver databaseDriver){
        this.databaseDriver = databaseDriver;
    }

    public ArrayList<Contest> getContests(boolean showLineups){
        //database won't store the list of lineups with contest objs. those
        //will need to be queried seperately if requested
        ArrayList<Contest> contestList = this.databaseDriver.getContests();

        if( showLineups ){
            for(Contest contest : contestList){
                contest.setLineups(this.databaseDriver.getLineups(contest.getId()));
            }
        }

        return contestList;
    }

    public Contest getContest(Integer id, boolean showLineups){
        Contest contest = this.databaseDriver.getContest(id);

        if( showLineups ){
            contest.setLineups(this.databaseDriver.getLineups(id));
        }

        return contest;
    }

    public ArrayList<Lineup> getLineups(){
        return this.databaseDriver.getLineups();
    }

    public Lineup getLineups(Integer lineupId){
        return this.databaseDriver.getLineup(lineupId);
    }

    public PlayerResponse getPlayers(PlayerQuery query){
        ArrayList<Player> playerEntries = this.databaseDriver.getPlayers();

        PlayerResponse playerResponse = new PlayerResponse();
        playerResponse.setPlayers(playerEntries);
        return playerResponse;
    }

    public void createContest(Contest contest){
        synchronized (this){
            contest.setId(this.databaseDriver.getNewContestId());
        }

        this.databaseDriver.insertContest(contest);
    }

    public void addLineup(Lineup lineup){
        synchronized (this){
            lineup.setLineupId(this.databaseDriver.getNewLineupId());
        }

        this.databaseDriver.insertLineup(lineup);
    }

    public void addPlayer(Player player){

        if( this.databaseDriver.playerExists(player.getName()) ){
            LOGGER.warn("Creating player with name that exists: "+player.getName());
        }

        synchronized (this){
            player.setId(this.databaseDriver.getNewPlayerId());
        }

        this.databaseDriver.insertPlayer(player);
    }
}
