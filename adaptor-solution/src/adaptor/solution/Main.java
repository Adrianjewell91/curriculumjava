package adaptor.solution;

import java.lang.reflect.InvocationTargetException;

public class Main {

  public static final boolean USE_CACHE_VAL = true;
  public static final boolean USE_DB_VAL = false;

  public static void main(String[] args)
      throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
    Main a = new Main();
    Controller c = a.getController();

    IResponse cacheReponse = c.get(USE_CACHE_VAL);
    IResponse dbResponse = c.get(USE_DB_VAL);

    runTests((Response) dbResponse, (ResponseFacade) cacheReponse);
  }

  public static void runTests(Object dbResponse, Object cacheReponse)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
    System.out.println(dbResponse.getClass().getDeclaredMethod("getA").invoke(dbResponse).equals(cacheReponse.getClass().getDeclaredMethod("getA").invoke(cacheReponse)));
    System.out.println(dbResponse.getClass().getDeclaredMethod("getB").invoke(dbResponse).equals(cacheReponse.getClass().getDeclaredMethod("getB").invoke(cacheReponse)));
    System.out.println(dbResponse.getClass().getDeclaredMethod("getC").invoke(dbResponse).equals(cacheReponse.getClass().getDeclaredMethod("getC").invoke(cacheReponse)));

    System.out.println(!dbResponse.getClass().equals(cacheReponse.getClass()));
    System.out.println(cacheReponse.getClass().getDeclaredField("cacheResponse").getType().getName().contains("CacheResponse"));
  }

  public Controller getController() {
    return new Controller();
  }
}
