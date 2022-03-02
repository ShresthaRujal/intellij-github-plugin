package com.rujal.github.plugin.service.httpclient;

import com.intellij.openapi.components.ServiceManager;
import java.util.Optional;

public interface RequestHandler<T> {

  static RequestHandler getInstance() {
    return ServiceManager.getService(RequestHandler.class);
  }

  Optional<T> get();

  Optional<T> post();

  Optional<T> put();
}
