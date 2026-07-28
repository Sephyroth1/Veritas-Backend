package org.example.Expression;

import org.example.Graph.Visitor;

public class NumberExpression implements Expression {
  private int value;

  public NumberExpression(int value) {
    this.value = value;
  }

  public void print(StringBuilder sb) {
    sb.append(value);
  }

  public <R> R accept(Visitor<R> visitor) {
    return visitor.visitNumberExpression(this);
  }

  public int getValue() {
    return value;
  }
}
