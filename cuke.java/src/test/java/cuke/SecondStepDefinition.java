package cuke;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.*;

public class SecondStepDefinition {

    protected World world;

    public SecondStepDefinition(World world){
        this.world = world;
    }

    @Given("[{lang}] I eat")
    public void i_have_x_cucumbers(LangBridge lang){
        System.out.println("MeState : " + this.world.state);
    }
}
