package org.example.Parselets;

import org.example.Core.Parser;
import org.example.Core.Precedence;
import org.example.Core.Token;
import org.example.Expression.AssignExpression;
import org.example.Expression.Expression;
import org.example.Expression.NameExpression;

public class AssignParselet implements InfixParselet {

  @Override
  public Expression parse(Parser parser, Token token, Expression left) {

    if (!(left instanceof NameExpression name)) {
      throw new RuntimeException("Left side of assignment must be a name.");
    }

    Expression right = parser.parseExpression(getPrecedence() - 1);

    return new AssignExpression(name, right);
  }

  @Override
  public int getPrecedence() {
    return Precedence.ASSIGNMENT;
  }
}
