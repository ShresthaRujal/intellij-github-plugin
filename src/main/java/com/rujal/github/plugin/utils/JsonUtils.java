package com.rujal.github.plugin.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import java.util.Optional;

public class JsonUtils {

  public static <T> Optional<T> convertToObject(String jsonString, Type t) {
    if (((Class<?>) (t)).isInstance(new String())) {
      return Optional.ofNullable((T) jsonString);
    }
    GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
    Gson gson = builder.create();
    return Optional.ofNullable(gson.fromJson(jsonString, t));
  }

}
