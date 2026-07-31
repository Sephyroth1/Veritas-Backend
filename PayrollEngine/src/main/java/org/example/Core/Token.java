package org.example.Core;

import org.example.Utils.TokenType;

public record Token(
    TokenType type,
    String lexeme) {
  public String stringify() {
    if (type == TokenType.NUMBER || type == TokenType.IDENT) {
      return lexeme;
    }
    return type.stringify();
  }
}
