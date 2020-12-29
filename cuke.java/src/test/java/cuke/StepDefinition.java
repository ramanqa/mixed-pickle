package cuke;

import io.cucumber.java.en.*;

public class StepDefinition{

    private World world;

    public StepDefinition(World world){
        this.world = world;
    }

    @Given("^I have (.*) cucumbers$")
    public void i_have_x_cucumbers(String xCucumbers){
        System.out.println("Cucumbers : " + xCucumbers);
        if(this.world.state == null){
            this.world.state = "First";
        }
        System.out.println("State : " + this.world.state);
    }

}
