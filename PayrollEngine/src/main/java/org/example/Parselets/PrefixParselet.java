package org.example.Parselets;

import org.example.Expression.Expression;
import org.example.Core.Parser;
import org.example.Core.Token;

public interface PrefixParselet {
  public Expression parse(Parser parser, Token token);
}
