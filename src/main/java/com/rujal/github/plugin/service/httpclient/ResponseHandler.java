package com.rujal.github.plugin.service.httpclient;

import java.net.http.HttpRequest;
import java.util.Optional;

public interface ResponseHandler<T> {

  /**
   * Handles the Response
   * @param request
   * @return
   */
  Optional<T> build(HttpRequest request);
}
