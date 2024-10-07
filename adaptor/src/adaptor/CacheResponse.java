package adaptor;

public class CacheResponse {
  private String a;
  private Details details;

  public CacheResponse(String A, Details d) {
    a = A;
    details = d;
  }

  public String getA() {
    return a;
  }

  public Details getDetails() {
    return details;
  }
}
