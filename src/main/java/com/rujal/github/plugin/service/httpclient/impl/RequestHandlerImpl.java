package com.rujal.github.plugin.service.httpclient.impl;

import com.rujal.github.plugin.constants.URIs;
import com.rujal.github.plugin.exception.URIException;
import com.rujal.github.plugin.service.httpclient.RequestHandler;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Optional;

public class RequestHandlerImpl<T> extends ResponseHandlerImpl implements RequestHandler<T> {

  @Override
  public Optional<T> get() {
    try {
      HttpRequest request = HttpRequest.newBuilder().uri(new URI(URIs.GITHUB_URL))
          .version(HttpClient.Version.HTTP_2).GET().build();
      return super.build(request);
    } catch (URISyntaxException e) {
      throw new URIException(e.getMessage());
    }
  }

  @Override
  public Optional<T> post() {
    return null;
  }

  @Override
  public Optional<T> put() {
    return null;
  }


  public static void main(String[] args) {
    new RequestHandlerImpl<String>().get();
  }
}
