package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.example.CompilerException.LexerException;
import org.example.Core.Lexer;
import org.example.Core.Token;
import org.example.Utils.TokenType;
import org.junit.jupiter.api.Test;

public class LibraryTest {

  private String input;

  @Test
  void testLexer() {
    input = """
        Basic = 50000
        HRA = Basic * 0.4
        PF = Basic * 0.12
        Net = Basic + HRA - PF
        """;

    List<Token> result = new Lexer(input).lex();

    List<Token> expected = List.of(
        new Token(TokenType.IDENT, "Basic"),
        new Token(TokenType.EQUAL, "="),
        new Token(TokenType.NUMBER, "50000"),
        new Token(TokenType.IDENT, "HRA"),
        new Token(TokenType.EQUAL, "="),
        new Token(TokenType.IDENT, "Basic"),
        new Token(TokenType.MUL, "*"),
        new Token(TokenType.DOUBLE, "0.4"),
        new Token(TokenType.IDENT, "PF"),
        new Token(TokenType.EQUAL, "="),
        new Token(TokenType.IDENT, "Basic"),
        new Token(TokenType.MUL, "*"),
        new Token(TokenType.DOUBLE, "0.12"),
        new Token(TokenType.IDENT, "Net"),
        new Token(TokenType.EQUAL, "="),
        new Token(TokenType.IDENT, "Basic"),
        new Token(TokenType.ADD, "+"),
        new Token(TokenType.IDENT, "HRA"),
        new Token(TokenType.SUB, "-"),
        new Token(TokenType.IDENT, "PF"),
        new Token(TokenType.EOF, "EOF"));

    assertEquals(expected, result);
  }

  @Test
  void testLexerThrowsException() {
    input = "2a3";

    LexerException exception = assertThrows(
        LexerException.class,
        () -> new Lexer(input).lex());

    assertEquals(
        "Unexpected character a was found on the line : 1",
        exception.getMessage());
  }

  @Test
  void testFullEvaluation() {
    input = """
        Basic = 50000
        HRA = Basic * 0.4
        PF = Basic * 0.12
        Net = Basic + HRA - PF
        """;

    PayrollEngine engine = new PayrollEngine();
    Map<String, BigDecimal> result = engine.evaluate(input);

    assertEquals(new BigDecimal("50000"), result.get("Basic"));
    assertEquals(new BigDecimal("20000.0"), result.get("HRA"));
    assertEquals(new BigDecimal("6000.00"), result.get("PF"));
    assertEquals(new BigDecimal("64000.00"), result.get("Net"));

    // Optional: print values while debugging
    for (Entry<String, BigDecimal> entry : result.entrySet()) {
      System.out.println(entry.getKey() + " = " + entry.getValue());
    }
  }
}
