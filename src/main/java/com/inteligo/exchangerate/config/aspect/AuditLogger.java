package com.inteligo.exchangerate.config.aspect;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class AuditLogger {

  private static final Marker AUDIT_MARKER = MarkerFactory.getMarker("AUDIT");

  private AuditLogger() {
    // Constructor del AuditResponse
  }

  public static void log(Logger logger, final String message) {
    logger.error(AUDIT_MARKER, message);
  }

  public static void log(Logger logger, final String format, final Object... arguments) {
    logger.error(AUDIT_MARKER, format, arguments);
  }

}
