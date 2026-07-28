package org.example.Expression;

public class NumberExpression implements Expression {
  private int value;

  public NumberExpression(int value) {
    this.value = value;
  }

  public void print(StringBuilder sb) {
    sb.append(value);
  }
}
