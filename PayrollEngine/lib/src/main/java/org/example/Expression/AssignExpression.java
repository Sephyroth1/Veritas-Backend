package org.example.Expression;

public class AssignExpression implements Expression {
  private Expression right;
  private String name;

  public AssignExpression(String name, Expression right) {
    this.name = name;
    this.right = right;
  }

  public void print(StringBuilder sb) {
    sb.append("(");
    sb.append(" = ");
    sb.append(name);
    right.print(sb);
    sb.append(")");
  }
}
