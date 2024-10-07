package adaptor;

import static adaptor.solution.Main.runTests;

import java.lang.reflect.InvocationTargetException;

public class Main {
  public static void main(String[] args)
      throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
    Main a = new Main();
    Controller c = a.getController();

    boolean USE_CACHE_VAL = true;
    boolean USE_DB_VAL = false;

//    Response cacheReponse = c.get(USE_CACHE_VAL);
//    Object cacheReponse = new Object();
    Response cacheReponse = new Response("a", "b" , "c");
    Response dbResponse   = c.get(USE_DB_VAL);

    runTests(dbResponse, cacheReponse);
  }

  public Controller getController() {
    return new Controller();
  }
}
