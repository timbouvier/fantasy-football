package com.tbouvier.fantasyfootball.server.resources;


import com.google.common.annotations.GwtIncompatible;
import com.tbouvier.fantasyfootball.server.api.Contest;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import javax.ws.rs.core.Response;
import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by bouviti on 6/21/18.
 */
public class FantasyFootballAppControllerTest {

    @Mock
    private Driver driver;

    private FantasyFootballAppController controller;

    @Before
    public void setup(){
        this.driver = mock(Driver.class);
        this.controller = new FantasyFootballAppController(this.driver);
    }

    @Ignore
    private Contest getBasicContest(Contest.Type type){
        Contest contest = new Contest();
        contest.setId(0);
        contest.setEndTime(Long.valueOf(1));
        contest.setStartTime(Long.valueOf(0));
        contest.setType(type);

        return contest;
    }

    @Test
    public void getContestsTest(){

        ArrayList<Contest> contests = new ArrayList<>();

        for(int i = 0 ; i < 10 ; i++){
            contests.add(this.getBasicContest(Contest.Type.HEAD_TO_HEAD));
        }

        when(this.driver.getContests(false)).thenReturn(contests);
        Response response = this.controller.getContests(false);

        assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
    }



    @Test
    public void addContestTest(){
        Contest contest = this.getBasicContest(Contest.Type.HEAD_TO_HEAD);

        Response response = this.controller.createContest(contest);

        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
    }

    //add more tests here

}
