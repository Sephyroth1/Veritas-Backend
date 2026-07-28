package org.example.Utils;

public enum TokenType {
  ADD,
  SUB,
  MUL,
  DIV,
  OR,
  AND,
  LEFT_PAREN,
  RIGHT_PAREN,
  GT,
  LT,
  EGT,
  ELT,
  EE,
  EQUAL, NUMBER,
  EOF,
  IDENT;

  public String stringify() {
    switch (this) {
      case ADD:
        return "+";
      case SUB:
        return "-";
      case MUL:
        return "*";
      case DIV:
        return "/";
      case OR:
        return "|";
      case AND:
        return "&";
      case LEFT_PAREN:
        return "(";
      case RIGHT_PAREN:
        return ")";
      case GT:
        return ">";
      case LT:
        return "<";
      case EGT:
        return ">=";
      case ELT:
        return "<=";
      case EE:
        return "==";
      case EQUAL:
        return "=";
      case EOF:
        return "EOF";
      case NUMBER:
        return "NUMBER";
      case IDENT:
        return "IDENT";
      default:
        throw new IllegalArgumentException("Token Type doesn't have a fixed String representation of this type" + this);
    }
  }
}
