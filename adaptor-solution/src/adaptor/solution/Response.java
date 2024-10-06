package adaptor.solution;

class Response implements IResponse {
  private String a;
  private String b;
  private String c;

  public Response(String A, String B, String C) {
    a = A;
    b = B;
    c = C;
  }

  public String getA() {
    return a;
  }

  public String getB() {
    return b;
  }

  public String getC() {
    return c;
  }
}
