package org.example.Utils;

import java.util.HashMap;
import java.util.Map;

public class CharacterStream {
  private String input;
  private int ind;
  private Map<String, TokenType> keywords;

  public CharacterStream(String input) {
    this.input = input;
    this.ind = 0;
    this.keywords = new HashMap<>();
    for (TokenType t : TokenType.values()) {
      keywords.put(t.stringify(), t);
    }
  }

  public boolean isAtEnd() {
    return this.ind >= input.length();
  }

  public void advance() {
    this.ind++;
  }

  public void advance(int offset) {
    this.ind += offset;
  }

  public char peek() {
    if (!this.isAtEnd()) {
      return this.input.charAt(this.ind);
    }
    return '\0';
  }

  public char next() {
    this.advance();
    return this.peek();
  }

  public char peek(int offset) {
    if (this.ind + offset < this.input.length()) {
      return this.input.charAt(this.ind + offset);
    } else {
      return '\0';
    }
  }

  public TokenType getType(String c) {
    return this.keywords.get(c);
  }

  public int getInd() {
    return this.ind;
  }
}
