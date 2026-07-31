package org.example.Expression;

import org.example.Graph.Visitor;

public class AssignExpression implements Expression {
  private Expression right;
  private NameExpression name;

  public AssignExpression(NameExpression name, Expression right) {
    this.name = name;
    this.right = right;
  }

  public void print(StringBuilder sb) {
    sb.append("(");
    sb.append("=");
    sb.append(" ");
    name.print(sb);
    sb.append(" ");
    right.print(sb);
    sb.append(")");
  }

  public <R> R accept(Visitor<R> visitor) {
    return visitor.visitAssignExpression(this);
  }

  public NameExpression getName() {
    return name;
  }

  public Expression getRight() {
    return right;
  }
}
