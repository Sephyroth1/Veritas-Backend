package org.example.Parselets;

import java.math.BigDecimal;

import org.example.Core.Parser;
import org.example.Core.Token;
import org.example.Expression.Expression;
import org.example.Expression.NumberExpression;

public class NumberParselet implements PrefixParselet {
  public Expression parse(Parser parser, Token token) {
    return new NumberExpression(new BigDecimal(token.lexeme()));
  }
}
