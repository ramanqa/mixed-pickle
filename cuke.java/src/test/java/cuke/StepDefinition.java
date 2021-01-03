package cuke;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.*;

public class StepDefinition{
    
    protected World world;

    public StepDefinition(World world){
        this.world = world;
    }

    @Given("[{lang}] abc")
    public void abc(Language lang) {
        System.out.println(lang);
        System.out.println("Cucumber done");
    }

    @Given("[{lang}] I have {} cucumbers")
    public void i_have_x_cucumbers(Language lang, String xCucumbers){
        System.out.println(lang.send("MEMEMEMEMMEME"));
    }

}
