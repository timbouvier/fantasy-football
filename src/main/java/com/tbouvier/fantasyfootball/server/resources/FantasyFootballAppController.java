package com.tbouvier.fantasyfootball.server.resources;

import com.google.inject.Inject;
import com.tbouvier.fantasyfootball.server.api.Contest;
import com.tbouvier.fantasyfootball.server.api.Lineup;
import com.tbouvier.fantasyfootball.server.api.Player;
import com.tbouvier.fantasyfootball.server.api.PlayerQuery;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

/**
 * Created by bouviti on 6/20/18.
 */
@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FantasyFootballAppController {

    private Driver driver;
    private Logger LOGGER = LoggerFactory.getLogger(FantasyFootballAppController.class);

    @Inject
    public FantasyFootballAppController(Driver driver){
        this.driver = driver;
    }

    @GET
    @Path("/contests")
    public Response getContests(@QueryParam("showlineups") @DefaultValue("false") boolean showLineups){
        try{
            return Response.ok(this.driver.getContests(showLineups)).build();
        }catch (Exception e) {
            LOGGER.error(e.toString());
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/contests/{id}")
    public Response getContest(@NotNull @PathParam("id") Integer id,
                               @QueryParam("showlineups") @DefaultValue("false") boolean showLineups){
        try{
            return Response.ok(this.driver.getContest(id, showLineups)).build();
        }catch(Exception e){
            LOGGER.error(e.toString());
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/lineups")
    public Response getLineups(){
        try{
            return Response.ok(this.driver.getLineups()).build();
        }catch (Exception e){
            LOGGER.error(e.toString());
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/lineups/{lineupid}")
    public Response getUserLineups(@NotNull @PathParam("lineupid") Integer id){
        try{
            return Response.ok(this.driver.getLineups(id)).build();
        }catch (Exception e){
            LOGGER.error(e.toString());
            return Response.serverError().build();
        }
    }


    @GET
    @Path("/players")
    public Response getPlayerNames(@NotEmpty @Valid PlayerQuery query){
        try{
            return Response.ok(this.driver.getPlayers(query)).build();
        }catch (Exception e){
            LOGGER.error(e.toString());
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/contests")
    public Response createContest(@NotEmpty @Valid Contest contest){
        try{
            this.driver.createContest(contest);
            return Response.created(URI.create("/api/contests/"+contest.getId())).build();
        }catch (Exception e){
            LOGGER.error(e.toString());
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/contests/{contestId}/lineups")
    public Response addLineup(@NotEmpty @Valid Lineup lineup){
        try{
            this.driver.addLineup(lineup);
            return Response.ok(URI.create("/api/lineups/"+lineup.getLineupId())).build();
        }catch (Exception e){
            LOGGER.error(e.toString());
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/players")
    public Response addPlayer(@NotEmpty @Valid Player playerEntry){
        try{
            this.driver.addPlayer(playerEntry);
            return Response.created(URI.create("/api/players/"+playerEntry.getId())).build();
        }catch (Exception e){
            LOGGER.error(e.toString());
            return Response.serverError().build();
        }
    }

}
