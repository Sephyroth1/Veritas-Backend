package org.example.Core;

import java.util.ArrayList;
import java.util.List;

import org.example.Utils.CharacterStream;
import org.example.Utils.TokenType;

public class Lexer {
  private CharacterStream stream;

  public Lexer(String input) {
    this.stream = new CharacterStream(input);
  }

  public List<Token> lex() {
    List<Token> tokens = new ArrayList<>();
    while (!stream.isAtEnd()) {
      StringBuilder sb = new StringBuilder();
      if (Character.isDigit(stream.peek())) {
        sb.setLength(0);
        while (!stream.isAtEnd() && Character.isDigit(stream.peek())) {
          sb.append(stream.peek());
          stream.advance();
        }
        tokens.add(new Token(TokenType.NUMBER, sb.toString()));
      } else if (Character.isLetter(stream.peek())) {
        sb.setLength(0);
        while (!stream.isAtEnd() && Character.isLetter(stream.peek())) {
          sb.append(stream.peek());
          stream.advance();
        }
        tokens.add(new Token(TokenType.IDENT, sb.toString()));
      } else {
        if (stream.peek() == '<') {
          if (stream.peek(1) == '=') {
            tokens.add(new Token(TokenType.ELT, "<="));
            stream.advance(2);
          } else {
            tokens.add(new Token(TokenType.LT, "<"));
            stream.advance();
          }
          continue;
        } else if (stream.peek() == '>') {
          if (stream.peek(1) == '=') {
            tokens.add(new Token(TokenType.EGT, ">="));

            stream.advance(2);
          } else {
            tokens.add(new Token(TokenType.GT, ">"));

            stream.advance();
          }

          continue;
        } else if (stream.peek() == '=') {
          if (stream.peek(1) == '=') {
            tokens.add(new Token(TokenType.EE, "=="));

            stream.advance(2);
          } else {
            tokens.add(new Token(TokenType.EQUAL, "="));

            stream.advance();
          }
          continue;
        }
        if (Character.isWhitespace(stream.peek())) {
          stream.advance();
          continue;
        }
        tokens.add(new Token(stream.getType(String.valueOf(stream.peek())), String.valueOf(stream.peek())));
      }
      stream.advance();
    }
    tokens.add(new Token(TokenType.EOF, "EOF"));
    return tokens;
  }
}
