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
        executeHelloWorldRules();

        Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        session.setGlobal("primaryStage", primaryStage);
        session.fireAllRules();

    }

    public static void executeHelloWorldRules() {
        KieServices ks = KieServices.Factory.get();
        BasicConfigurator.configure();
        Logger.getLogger(Main.class).setLevel(Level.OFF);
        KieContainer kContainer = ks.getKieClasspathContainer();
        session = kContainer.newKieSession("ksession-rules");
    }
}