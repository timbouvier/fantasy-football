package com.tbouvier.fantasyfootball.server.api;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bouviti on 6/20/18.
 */
public class Contest {

    enum Type {
        BASE_TYPE,
        HEAD_TO_HEAD,
        POOL_100,
        POOL_500,
        POOL_1000,
    };

    //driver will assign this value
    private Integer id;

    @NotEmpty
    private Long startTime;

    @NotEmpty
    private Long endTime;

    @NotEmpty
    private Type type;

    //optionally include a list of lineups that this contest contains
    //if caller requests
    private ArrayList<Lineup> lineups;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public ArrayList<Lineup> getLineups() {
        return lineups;
    }

    public void setLineups(ArrayList<Lineup> lineups) {
        this.lineups = lineups;
    }

    public void addLineup(Lineup lineup){
        this.lineups.add(lineup);
    }
}
