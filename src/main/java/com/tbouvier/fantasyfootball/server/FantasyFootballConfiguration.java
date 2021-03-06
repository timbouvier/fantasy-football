package com.tbouvier.fantasyfootball.server;

import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by bouviti on 6/19/18.
 */
public class FantasyFootballConfiguration extends Configuration {

    @NotEmpty
    private String databaseAddress;

    @NotNull
    private Integer databasePort;

    public String getDatabaseAddress() {
        return databaseAddress;
    }

    public void setDatabaseAddress(String databaseAddress) {
        this.databaseAddress = databaseAddress;
    }

    public Integer getDatabasePort() {
        return databasePort;
    }

    public void setDatabasePort(Integer databasePort) {
        this.databasePort = databasePort;
    }
}
