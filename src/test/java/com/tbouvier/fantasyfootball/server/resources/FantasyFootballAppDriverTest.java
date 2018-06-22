package com.tbouvier.fantasyfootball.server.resources;

import com.tbouvier.fantasyfootball.server.api.Contest;
import com.tbouvier.fantasyfootball.server.api.Lineup;
import com.tbouvier.fantasyfootball.server.database.DatabaseDriver;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

/**
 * Created by bouviti on 6/21/18.
 */
public class FantasyFootballAppDriverTest {

    @Mock
    private DatabaseDriver databaseDriver;

    private FantasyFootballAppDriver driver;

    @Before
    public void setup(){
        this.databaseDriver = mock(DatabaseDriver.class);
        this.driver = new FantasyFootballAppDriver(this.databaseDriver);
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

    @Ignore
    private Lineup getBasicLineup(){
        Lineup lineup = new Lineup();
        lineup.setLineupId(1);
        lineup.setContestId(0);
        lineup.setUserId(123);

        return lineup;
    }

    @Test
    public void getContestsWithLineupsTest(){
        ArrayList<Contest> contests = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++){
            contests.add(this.getBasicContest(Contest.Type.HEAD_TO_HEAD));
        }

        ArrayList<Lineup> lineups = new ArrayList<>();
        for(int i = 0 ; i < 10; i++){
            lineups.add(this.getBasicLineup());
        }

        when(this.databaseDriver.getContests()).thenReturn(contests);
        when(this.databaseDriver.getLineups(0)).thenReturn(lineups);


        //Request contests WITH lineups present in returned object
        ArrayList<Contest> result = this.driver.getContests(true);


        for(Contest contest : result){
            assertNotNull(contest.getLineups());
        }
    }


    //add more tests here

}
