package adaptor;

import static adaptor.solution.Main.USE_CACHE_VAL;
import static adaptor.solution.Main.USE_DB_VAL;
import static adaptor.solution.Main.runTests;

import java.lang.reflect.InvocationTargetException;

public class Main {
  public static void main(String[] args)
      throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
    Main a = new Main();
    Controller c = a.getController();

    /*
     * A few different ways to think about the cached response reveal the different aspects of the test.
     */
    Response cacheReponse = new Response("a", "b" , "c");
//    Response cacheReponse = c.get(USE_CACHE_VAL);
//    Object cacheReponse = new Object();
//    CacheResponse cacheReponse = new CacheResponse("A",
//        new Details("B", "C")
//    );
    Response dbResponse   = c.get(USE_DB_VAL);

    runTests(dbResponse, cacheReponse);
  }

  public Controller getController() {
    return new Controller();
  }
}
