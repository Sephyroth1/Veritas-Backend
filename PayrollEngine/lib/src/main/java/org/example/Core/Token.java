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

// public class Token {
// private String lexeme;
// private int line;
// private TokenType type;
//
// public Token(TokenType type, String lexeme, int line) {
// this.type = type;
// this.lexeme = lexeme;
// this.line = line;
// }
//
// public String getLexeme() {
// return lexeme;
// }
//
// public int getLine() {
// return line;
// }
//
// public TokenType getType() {
// return type;
// }
//
// public void setLexeme(String lexeme) {
// this.lexeme = lexeme;
// }
//
// public void setLine(int line) {
// this.line = line;
// }
//
// public void setType(TokenType type) {
// this.type = type;
// }
//
// @Override
// public String toString() {
// return "Token{" + "lexeme='" + lexeme + '\'' + ", line=" + line + ", type=" +
// type + '}';
// }
// }
