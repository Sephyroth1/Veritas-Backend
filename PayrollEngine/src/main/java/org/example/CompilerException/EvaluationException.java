package org.example.CompilerException;

public class EvaluationException extends RuntimeException {
  public EvaluationException() {
    super();
  }

  public EvaluationException(String message) {
    super(message);
  }

  public EvaluationException(String message, Throwable cause) {
    super(message, cause);
  }
}
