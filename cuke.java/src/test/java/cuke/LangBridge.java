package cuke;

import java.util.UUID;

public class LangBridge{

    String lang;
    World world;

    public LangBridge(World world, String language){
        this.lang = language.toLowerCase();
        this.world = world;
    }

    public String toString(){
        return this.lang;
    }

    public UUID execute(String function){
        return this.world.cukeWS.send(this.lang, function);
    }
}
