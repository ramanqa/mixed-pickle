package cuke;

import java.util.UUID;

public class Language{

    String lang;
    World world;

    public Language(World world, String language){
        this.lang = language.toUpperCase();
        this.world = world;
    }

    public String toString(){
        return this.lang;
    }

    public UUID send(String message){
        return this.world.cukeWS.send(this.lang, message);
    }
}
