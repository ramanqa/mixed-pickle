package eh.qe;

import io.javalin.Javalin;
import io.javalin.websocket.WsContext;
import io.javalin.websocket.WsMessageContext;

import java.util.Map;
import java.util.HashMap;
import java.util.UUID;

public class CukeWS{

    Javalin cukeWS;
    Map<String, WsContext> wsConnections;

    public static void main(String args[]){
        CukeWS cukeWSClass = new CukeWS();
        cukeWSClass.start();
    }

    public CukeWS start(){
        this.wsConnections = new HashMap<>(); 
    
        System.out.println("Starting Cuke WS at port 4001");
        this.cukeWS = Javalin.create().start(4001);

        this.cukeWS.get("/", context -> {
            context.result("status ok");
        });

        this.cukeWS.ws("/:lang", ws -> {
        
          ws.onConnect(context -> {
              System.out.println("Connected." + context.pathParam("lang"));
              this.wsConnections.put(context.pathParam("lang"), context);
          });

          ws.onMessage(context -> {
              this.interpreteMessage(context);
          });
        });

        return this;
    }

    public void interpreteMessage(WsMessageContext context){
        System.out.println(context.pathParam("lang"));
        System.out.println(context.message());
    }

    public UUID send(String channel, String message){
        UUID uuid = UUID.randomUUID();
        String body = "{'uuid':"+uuid+", 'message': "+message+"}";
        this.wsConnections.get(channel.toLowerCase()).send(body);
        return uuid;
    }

    public void quit(){
      this.cukeWS.stop();
    }

}
