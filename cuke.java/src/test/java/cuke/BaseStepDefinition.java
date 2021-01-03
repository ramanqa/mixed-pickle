package cuke;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.*;
import io.cucumber.java.Before;
import io.cucumber.java.After;

import eh.qe.CukeWS;

public class BaseStepDefinition{
    
    protected World world;

    public BaseStepDefinition(World world){
        this.world = world;
    }

    @ParameterType(".*")
    public Language lang(String language){
        return new Language(this.world, language);
    }

    @Before
    public void setUpScenario(){
        // start CukeWS
        this.world.cukeWS = new CukeWS();
        this.world.cukeWS.start();
        System.out.println("Connect");
        try{Thread.sleep(10000);}catch(Exception e){}
    }

    @After
    public void tearDownScenario(){
        // stop CukeWS
        this.world.cukeWS.quit();
    }
}
