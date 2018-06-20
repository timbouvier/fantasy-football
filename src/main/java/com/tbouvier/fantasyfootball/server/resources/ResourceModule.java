package com.tbouvier.fantasyfootball.server.resources;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.tbouvier.fantasyfootball.server.FantasyFootballConfiguration;
import com.tbouvier.fantasyfootball.server.database.DatabaseDriver;
import com.tbouvier.fantasyfootball.server.database.MongoDBDriver;
import io.dropwizard.Configuration;

/**
 * Created by bouviti on 6/20/18.
 */
public class ResourceModule extends AbstractModule {

    private FantasyFootballConfiguration configuration;

    public ResourceModule(FantasyFootballConfiguration configuration){
        this.configuration = configuration;
    }

    @Override
    protected void configure(){
        bind(Driver.class).to(FantasyFootballAppDriver.class);
        bind(DatabaseDriver.class).to(MongoDBDriver.class);
    }

    @Provides
    MongoDBDriver provideMongoDBDriver(){
        MongoDBDriver driver =  new MongoDBDriver();

        driver.setAddress(this.configuration.getDatabaseAddress());
        driver.setPort(this.configuration.getDatabasePort());
        return driver;
    }
}
