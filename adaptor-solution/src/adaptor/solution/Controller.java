package adaptor.solution;

class Controller {
  public Controller() { /* TODO document why this constructor is empty */ }

  public IResponse get(boolean cache) {
    if (cache) {
      return new ResponseFacade(
          new CacheResponse("A",
              new Details("B", "C")
          )
      );
    }
    return new Response("A", "B", "C");
  }
}
