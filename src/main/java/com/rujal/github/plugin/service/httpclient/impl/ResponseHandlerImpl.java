package com.rujal.github.plugin.service.httpclient.impl;

import com.rujal.github.plugin.service.httpclient.ResponseHandler;
import com.rujal.github.plugin.utils.JsonUtils;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public abstract class ResponseHandlerImpl<T> implements ResponseHandler<T> {

  Class t;

  ResponseHandlerImpl(){
    Type superclass = this.getClass().getGenericSuperclass();
    try {
      t = ((ParameterizedType) superclass).getActualTypeArguments()[0].getClass();
    }catch (Exception e){
      t = String.class;
    }
  }

  @Override
  public Optional<T> build(HttpRequest request) {
    try {
      HttpClient client = HttpClient.newHttpClient();
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      return JsonUtils.convertToObject(response.body(), t);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }
}
