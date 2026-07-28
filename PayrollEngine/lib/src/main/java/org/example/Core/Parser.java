package org.example.Core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.Expression.Expression;
import org.example.Parselets.InfixParselet;
import org.example.Parselets.PrefixParselet;
import org.example.Utils.TokenType;

public class Parser {
  private List<Token> tokens;
  private int index;
  private Map<TokenType, PrefixParselet> prefixParselets;
  private Map<TokenType, InfixParselet> infixParselets;

  public Parser(List<Token> tokens) {
    this.tokens = tokens;
    this.index = 0;
    this.prefixParselets = new HashMap<>();
    this.infixParselets = new HashMap<>();
  }

  public Token consume() {
    if (!isAtEnd()) {
      return this.tokens.get(this.index++);
    }
    throw new RuntimeException("Unexpected end of input");
  }

  public boolean isAtEnd() {
    return this.index >= this.tokens.size();
  }

  public boolean match(TokenType type) {
    if (!isAtEnd()) {
      if (prefixParselets.containsKey(type) || infixParselets.containsKey(type)) {
        return true;
      }
    }
    return false;
  }

  public void register(TokenType type, PrefixParselet parselet) {
    prefixParselets.put(type, parselet);
  }

  public void register(TokenType type, InfixParselet parselet) {
    infixParselets.put(type, parselet);
  }

  public Token consume(TokenType type) {
    if (!match(type)) {

      throw new RuntimeException("Expected " + type.stringify() + " but got " + tokens.get(index).type().stringify());
    }

    return consume();
  }

  public Token peek() {
    return tokens.get(index);
  }

  public Expression parseExpression(int precedence) {
    Token token = consume();
    PrefixParselet prefixParselet = prefixParselets.get(token.type());

    if (prefixParselet == null) {
      throw new RuntimeException("No prefix parselet for " + token.type().stringify());
    }

    Expression left = prefixParselet.parse(this, token);

    while (precedence < getPrecedence(peek().type())) {
      InfixParselet infix = infixParselets.get(peek().type());
      left = infix.parse(this, consume(), left);
    }

    return left;
  }

  public int getPrecedence(TokenType type) {
    InfixParselet infixParselet = infixParselets.get(type);
    if (infixParselet != null) {
      return infixParselet.getPrecedence();
    }
    return 0;
  }

  public Expression parseExpression() {
    return parseExpression(0);
  }
}
