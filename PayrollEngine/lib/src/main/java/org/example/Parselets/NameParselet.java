package org.example.Parselets;

import org.example.Core.Parser;
import org.example.Core.Token;
import org.example.Expression.Expression;
import org.example.Expression.NameExpression;

public class NameParselet implements PrefixParselet {
  public Expression parse(Parser parser, Token token) {
    return new NameExpression(token.lexeme());
  }
}
