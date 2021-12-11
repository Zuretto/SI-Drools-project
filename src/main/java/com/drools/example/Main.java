package com.drools.example;
import javafx.application.Application;
import javafx.stage.Stage;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


public class Main extends Application {

    static KieSession session;

    public static void main(String[] args) {
        initializeKieSession();

        Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Electronic Music for People Who Don't Like Electronic Music");


        session.setGlobal("primaryStage", primaryStage);
        session.fireAllRules();

    }

    public static void initializeKieSession() {
        KieServices ks = KieServices.Factory.get();
        BasicConfigurator.configure();
        Logger.getLogger(Main.class).setLevel(Level.OFF);
        KieContainer kContainer = ks.getKieClasspathContainer();
        session = kContainer.newKieSession("ksession-rules");
    }
}