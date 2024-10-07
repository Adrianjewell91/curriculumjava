package adaptor.solution;

class ResponseFacade implements IResponse {
  private CacheResponse cacheResponse;

  public ResponseFacade(CacheResponse cr) {
    cacheResponse = cr;
  }

  public String getA() {
    return cacheResponse.getA();
  }

  public String getB() {
    return cacheResponse.getDetails().getB();
  }

  public String getC() {
    return cacheResponse.getDetails().getC();
  }
}
