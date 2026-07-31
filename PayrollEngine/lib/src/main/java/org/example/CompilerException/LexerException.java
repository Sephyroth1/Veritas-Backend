package org.example.CompilerException;

public class LexerException extends RuntimeException {
  public LexerException() {
    super();
  }

  public LexerException(String message) {
    super(message);
  }

  public LexerException(String message, Throwable cause) {
    super(message, cause);
  }
}
