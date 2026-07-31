package org.example.Core;

public class Precedence {
  public static final int ASSIGNMENT = 1; // EQUAL
  public static final int LOGICAL_OR = 2; // OR
  public static final int LOGICAL_AND = 3; // AND
  public static final int EQUALITY = 4; // EE
  public static final int COMPARISON = 5; // GT, LT, EGT, ELT
  public static final int SUM = 6; // ADD, SUB
  public static final int PRODUCT = 7; // MUL, DIV
  public static final int EXPONENT = 8;
  public static final int PREFIX = 9;
  public static final int POSTFIX = 10;
  public static final int CALL = 11; // LEFT_PAREN (for function calls)
}
