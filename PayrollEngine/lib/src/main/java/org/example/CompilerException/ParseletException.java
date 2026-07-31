package org.example.CompilerException;

public class ParseletException extends RuntimeException {
  public ParseletException() {
    super();
  }

  public ParseletException(String message) {
    super(message);
  }

  public ParseletException(String message, Throwable cause) {
    super(message, cause);
  }
}
