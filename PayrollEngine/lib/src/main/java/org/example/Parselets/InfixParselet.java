package org.example.Parselets;

import org.example.Expression.Expression;
import org.example.Core.Parser;
import org.example.Core.Token;

public interface InfixParselet {
  public Expression parse(Parser parser, Token operator, Expression left);

  public int getPrecedence();
}
