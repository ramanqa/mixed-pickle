package cuke;

import io.cucumber.java.en.*;

public class SecondStepDefinition{

    private World world;

    public SecondStepDefinition(World world){
        this.world = world;
    }

    @Given("^I eat$")
    public void i_have_x_cucumbers(){
        System.out.println("MeState : " + this.world.state);
    }
}
