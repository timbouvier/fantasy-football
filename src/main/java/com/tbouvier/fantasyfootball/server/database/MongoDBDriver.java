package com.tbouvier.fantasyfootball.server.database;

import com.tbouvier.fantasyfootball.server.api.Contest;
import com.tbouvier.fantasyfootball.server.api.Lineup;
import com.tbouvier.fantasyfootball.server.api.Player;

import java.util.ArrayList;

/**
 * Created by bouviti on 6/20/18.
 */
public class MongoDBDriver implements DatabaseDriver {


    private String address;
    private Integer port;

    public void setAddress(String address){
        this.address = address;
    }

    public void setPort(Integer port){
        this.port = port;
    }

    public boolean connect(){
        return false;
    }

    public boolean disconnect(){
        return false;
    }

    public boolean isConnected(){
        return false;
    }

    //atomic fetch+increment/random hash
    public Integer getNewPlayerId(){
        return 0;
    }

    public Integer getNewContestId(){
        return 0;
    }

    public Integer getNewLineupId(){
        return 0;
    }

    public void insertPlayer(Player playerEntry){

    }

    public void insertContest(Contest contest){

    }

    public void insertLineup(Lineup lineup){

    }

    public Player getPlayer(Integer id){
        return new Player();
    }

    public boolean playerExists(String name){
        return false;
    }

    public ArrayList<Player> getPlayers(){
        return new ArrayList<>();
    }

    public Contest getContest(Integer id){
        return new Contest();
    }

    public ArrayList<Contest> getContests(){
        return new ArrayList<>();
    }

    public Lineup getLineup(Integer lineupId){
        return new Lineup();
    }

    public ArrayList<Lineup> getLineups(){
        return new ArrayList<>();
    }

    public ArrayList<Lineup> getLineups(Integer contestId){
        return new ArrayList<>();
    }
}
