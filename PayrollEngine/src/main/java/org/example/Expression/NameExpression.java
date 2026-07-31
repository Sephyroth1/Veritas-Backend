package org.example.Expression;

import org.example.Graph.Visitor;

public class NameExpression implements Expression {
  private String name;

  public NameExpression(String name) {
    this.name = name;
  }

  public void print(StringBuilder sb) {
    sb.append(name);
  }

  public String getName() {
    return name;
  }

  public <R> R accept(Visitor<R> visitor) {
    return visitor.visitNameExpression(this);
  }
}
