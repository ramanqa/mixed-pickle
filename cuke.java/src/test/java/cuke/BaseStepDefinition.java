package cuke;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.*;
import io.cucumber.java.Before;
import io.cucumber.java.After;

import eh.qe.CukeWS;

import java.io.IOException;

public class BaseStepDefinition{
    
    protected World world;

    public BaseStepDefinition(World world){
        this.world = world;
    }

    @ParameterType(".*")
    public LangBridge lang(String language){
        return new LangBridge(this.world, language);
    }

    @Before
    public void setUpScenario() throws IOException {
        // start CukeWS
        this.world.cukeWS = new CukeWS();
        this.world.cukeWS.start();
        System.out.println("Connect");
        try{Thread.sleep(1000);}catch(Exception e){}
        startJsLangBridge();   
        try{Thread.sleep(1000);}catch(Exception e){}
    }

    @After
    public void tearDownScenario() throws IOException {
        // stop CukeWS
        this.closeJsLangBridge();
        this.world.cukeWS.quit();
    }

    public Boolean isWindows(){
        return System.getProperty("os.name")
          .toLowerCase().startsWith("windows");
    }

    public void startJsLangBridge() throws IOException {
        if(isWindows()){
            startJsLangBridgeOnWin();
        }else{
            startJsLangBridgeOnLinux();
        }
    }

    public void startJsLangBridgeOnWin() throws IOException {
        String command = "CMD /C START npm start --prefix ../client-driver.js";
        this.world.jsLangBridgeProcess = Runtime.getRuntime().exec(command);
    }

    public void startJsLangBridgeOnLinux() throws IOException {
        String[] command = {"npm", "start", "--prefix", "../client-driver.js"};
        this.world.jsLangBridgeProcess = new ProcessBuilder(command).start();
    }

    public void closeJsLangBridge() throws IOException {
        if(isWindows()){
            Runtime.getRuntime().exec("wmic process where \"CommandLine " 
                + "like '%npm%' and CommandLine like '%--prefix ../client-driver.js"
                + "%'\" call terminate");
        }
        this.world.jsLangBridgeProcess.destroyForcibly(); 
    }
}
