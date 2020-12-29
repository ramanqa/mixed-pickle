package eh.qe.dsl;

import org.testng.annotations.*;

import java.util.concurrent.Future;

public class DSLTest{

    @Test
    public void firstDslTest() throws Exception{
        TestSession session = new TestSession();
        DSL dsl = new DSL(session);
        Future f1 = dsl.futureMessage("ABCABCABC", 3000);
        DSL dsl2 = new DSL(session);
        Future f2 = dsl2.futureMessage("XYCXYCYX", 5000);
        while(!f2.isDone()){
          //System.out.println(System.currentTimeMillis());
        }
        System.out.println(f1.get());
        System.out.println(f2.get());
    }
}
