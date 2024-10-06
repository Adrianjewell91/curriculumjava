package adaptor;

class Controller {
  public Controller() { /* TODO document why this constructor is empty */ }

  public Response get(boolean cache) {
    if (cache) {
      return null;
    }
    return new Response("A", "B", "C");
  }
}
