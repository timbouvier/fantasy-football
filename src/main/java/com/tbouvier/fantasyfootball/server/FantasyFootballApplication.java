package com.tbouvier.fantasyfootball.server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.tbouvier.fantasyfootball.server.resources.Driver;
import com.tbouvier.fantasyfootball.server.resources.FantasyFootballAppController;
import com.tbouvier.fantasyfootball.server.resources.ResourceModule;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bouviti on 6/19/18.
 */
public class FantasyFootballApplication extends Application<FantasyFootballConfiguration> {

    @Override
    public void run(FantasyFootballConfiguration configuration, Environment environment){

        //wire up our dependencies
        List<Module> modules = new ArrayList<>();
        modules.add(new ResourceModule(configuration));

        //create dependency injector
        Injector injector = Guice.createInjector(modules);

        //run our controller with instance of Driver
        final FantasyFootballAppController controller = new FantasyFootballAppController(injector.getInstance(Driver.class));
        environment.jersey().register(controller);
    }

    //main entrypoint
    public static void main(String[] args)throws Exception{
        new FantasyFootballApplication().run(args);
    }
}
