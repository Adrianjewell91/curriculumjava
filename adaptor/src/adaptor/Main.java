package adaptor;

public class Main {
  public static void main(String[] args) {
    Main a = new Main();
    Controller c = a.getController();

    boolean USE_CACHE_VAL = true;
    boolean USE_DB_VAL = false;

    Response cacheReponse = c.get(USE_CACHE_VAL);
    Response dbResponse   = c.get(USE_DB_VAL);

    System.out.println(!dbResponse.getClass().equals(cacheReponse.getClass()));
    System.out.println(dbResponse.getA().equals(cacheReponse.getA()));
    System.out.println(dbResponse.getB().equals(cacheReponse.getB()));
    System.out.println(dbResponse.getC().equals(cacheReponse.getC()));
  }

  public Controller getController() {
    return new Controller();
  }
}
