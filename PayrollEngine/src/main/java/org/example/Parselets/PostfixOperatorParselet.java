package org.example.Parselets;

import org.example.Core.Parser;
import org.example.Core.Token;
import org.example.Expression.Expression;
import org.example.Expression.PostfixExpression;

public class PostfixOperatorParselet implements InfixParselet {
  private int precedence;

  public PostfixOperatorParselet(int precedence) {
    this.precedence = precedence;
  }

  public Expression parse(Parser parser, Token token, Expression left) {
    return new PostfixExpression(left, token.type());
  }

  public int getPrecedence() {
    return this.precedence;
  }
}
