package org.example.CompilerException;

public class SemanticException extends RuntimeException {

  public SemanticException() {
    super();
  }

  public SemanticException(String message) {
    super(message);
  }

  public SemanticException(String message, Throwable cause) {
    super(message, cause);
  }
}
