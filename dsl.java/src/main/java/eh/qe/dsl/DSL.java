package eh.qe.dsl;

import com.jcabi.aspects.Async;
import com.jcabi.aspects.Loggable;
import java.util.concurrent.Future;
import java.util.concurrent.CompletableFuture;

public class DSL{

    TestSession testSession;
    String m;
    Integer timeout;

    public DSL(TestSession testSession){
    }

    @Async
    //@Loggable
    public Future<String> futureMessage(String m, Integer t){
        System.out.println("in futureMessage method ("+m+")");
        try{Thread.sleep(t);}catch(Exception e){}
        return CompletableFuture.completedFuture(m + " : " + System.currentTimeMillis());
    }
}
