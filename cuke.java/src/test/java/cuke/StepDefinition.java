package cuke;

import io.cucumber.java.en.*;

public class StepDefinition{
    
    protected World world;

    public StepDefinition(World world){
        this.world = world;
    }

    @Given("[{lang}] abc")
    public void abc(LangBridge lang) {
    }

    @Given("[{lang}] I have {} cucumbers")
    public void i_have_x_cucumbers(LangBridge lang, String xCucumbers){
        System.out.println(lang.execute("MEMEMEMEMMEME"));
    }

}
