package org.example.Core;

import org.example.Utils.TokenType;
import org.example.Parselets.BinaryOperatorParselet;
import org.example.Parselets.PrefixOperatorParselet;
import org.example.Parselets.PostfixOperatorParselet;
import org.example.Parselets.NumberParselet;
import org.example.Parselets.NameParselet;
import org.example.Parselets.AssignParselet;

public class LangParser extends Parser {
  public LangParser(Lexer lex) {
    super(lex.lex());

    register(TokenType.IDENT, new NameParselet());
    register(TokenType.NUMBER, new NumberParselet());
    register(TokenType.DOUBLE, new NumberParselet());

    prefix(TokenType.ADD, Precedence.PREFIX);
    prefix(TokenType.SUB, Precedence.PREFIX);

    infixLeft(TokenType.ADD, Precedence.SUM);
    infixLeft(TokenType.SUB, Precedence.SUM);
    infixLeft(TokenType.MUL, Precedence.PRODUCT);
    infixLeft(TokenType.DIV, Precedence.PRODUCT);
    infixLeft(TokenType.OR, Precedence.LOGICAL_OR);
    infixLeft(TokenType.AND, Precedence.LOGICAL_AND);
    infixLeft(TokenType.EE, Precedence.EQUALITY);
    infixLeft(TokenType.ELT, Precedence.COMPARISON);
    infixLeft(TokenType.EGT, Precedence.COMPARISON);
    infixLeft(TokenType.LT, Precedence.COMPARISON);
    infixLeft(TokenType.GT, Precedence.COMPARISON);
    assign(TokenType.EQUAL, Precedence.ASSIGNMENT);
  }

  public void assign(TokenType token, int precedence) {
    register(token, new AssignParselet());
  }

  public void postfix(TokenType token, int precedence) {
    register(token, new PostfixOperatorParselet(precedence));
  }

  public void prefix(TokenType token, int precedence) {
    register(token, new PrefixOperatorParselet(precedence));
  }

  public void infixLeft(TokenType token, int precedence) {
    register(token, new BinaryOperatorParselet(precedence, false));
  }

  public void infixRight(TokenType token, int precedence) {
    register(token, new BinaryOperatorParselet(precedence, true));
  }

}
