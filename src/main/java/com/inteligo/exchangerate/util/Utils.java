package com.inteligo.exchangerate.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {

  private static final Logger logger = LoggerFactory.getLogger(Utils.class);

  public static String printJsonFormat(Object object) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      return mapper.writeValueAsString(object);
    } catch (Exception ex) {
      logger.info("Unable to parse argument error: {}", ex);
    }
    return object.toString();
  }

  public static Object getCause(Throwable e) {
    boolean isCauseExist = e.getCause() != null && e.getCause().getMessage() != null;
    return isCauseExist ? e.getCause().getMessage() : getMessage(e);
  }

  public static String getMessage(Throwable e) {
    return e.getMessage() != null ? e.getMessage() : e.getClass().getSimpleName();
  }

}
