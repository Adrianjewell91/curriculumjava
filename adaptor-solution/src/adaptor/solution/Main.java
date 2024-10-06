package adaptor.solution;

public class Main {
  public static void main(String[] args) {
    Main a = new Main();
    Controller c = a.getController();
    boolean USE_CACHE_VAL = true;
    boolean USE_DB_VAL = false;

    IResponse cacheReponse = c.get(USE_CACHE_VAL);
    IResponse dbResponse = c.get(USE_DB_VAL);

    runTests(dbResponse, cacheReponse);
  }

  public static void runTests(IResponse dbResponse, IResponse cacheReponse) {
    System.out.println(!dbResponse.getClass().equals(cacheReponse.getClass()));
    System.out.println(dbResponse.getA().equals(cacheReponse.getA()));
    System.out.println(dbResponse.getB().equals(cacheReponse.getB()));
    System.out.println(dbResponse.getC().equals(cacheReponse.getC()));
  }

  public Controller getController() {
    return new Controller();
  }
}
