package org.example.Parselets;

import org.example.Core.Parser;
import org.example.Core.Token;
import org.example.Expression.Expression;
import org.example.Expression.PrefixExpression;

public class PrefixOperatorParselet implements PrefixParselet {
  private int precedence;

  public PrefixOperatorParselet(int precedence) {
    this.precedence = precedence;
  }

  public Expression parse(Parser parser, Token token) {
    Expression right = parser.parseExpression(precedence);
    return new PrefixExpression(right, token.type());
  }
}
