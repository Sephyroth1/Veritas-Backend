package org.example.Parselets;

import org.example.Core.Parser;
import org.example.Core.Token;
import org.example.Expression.BinaryExpression;
import org.example.Expression.Expression;

public class BinaryOperatorParselet implements InfixParselet {
  private int precedence;
  private boolean rightAssociative;

  public BinaryOperatorParselet(int precedence, boolean rightAssociative) {
    this.precedence = precedence;
    this.rightAssociative = rightAssociative;
  }

  public Expression parse(Parser parser, Token operator, Expression left) {
    Expression right = parser.parseExpression(rightAssociative ? precedence + 1 : precedence);
    return new BinaryExpression(left, operator.type(), right);
  }

  public int getPrecedence() {
    return this.precedence;
  }
}
