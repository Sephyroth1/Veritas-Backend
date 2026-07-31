package org.example.Expression;

import org.example.Graph.Visitor;
import org.example.Utils.TokenType;

public class PostfixExpression implements Expression {
  private Expression left;
  private TokenType operator;

  public PostfixExpression(Expression left, TokenType operator) {
    this.left = left;
    this.operator = operator;
  }

  public void print(StringBuilder sb) {
    sb.append("(");
    left.print(sb);
    sb.append(" ");
    sb.append(operator.stringify());
    sb.append(")");
  }

  public <R> R accept(Visitor<R> visitor) {
    return visitor.visitPostFixExpression(this);
  }

  public Expression getLeft() {
    return left;
  }
}
