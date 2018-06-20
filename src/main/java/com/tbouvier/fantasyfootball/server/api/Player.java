package com.tbouvier.fantasyfootball.server.api;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by bouviti on 6/20/18.
 */
public class Player {

    private Integer id;

    @NotEmpty
    private String name;

    private Integer score;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
