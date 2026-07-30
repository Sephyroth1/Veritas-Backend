package org.example.Expression;

import java.math.BigDecimal;

import org.example.Graph.Visitor;

public class NumberExpression implements Expression {
  private BigDecimal value;

  public NumberExpression(BigDecimal value) {
    this.value = value;
  }

  public void print(StringBuilder sb) {
    sb.append(value);
  }

  public <R> R accept(Visitor<R> visitor) {
    return visitor.visitNumberExpression(this);
  }

  public BigDecimal getValue() {
    return value;
  }
}
