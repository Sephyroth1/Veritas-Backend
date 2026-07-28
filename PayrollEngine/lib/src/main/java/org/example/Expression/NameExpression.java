package org.example.Expression;

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
}
