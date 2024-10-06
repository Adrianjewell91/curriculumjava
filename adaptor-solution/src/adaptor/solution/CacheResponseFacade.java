package adaptor.solution;

class CacheResponseFacade implements IResponse {
  private CacheResponse cacheResponse;

  public CacheResponseFacade(CacheResponse cr) {
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
