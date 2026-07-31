package org.example.Expression;

import org.example.Graph.Visitor;
import org.example.Utils.TokenType;

public class BinaryExpression implements Expression {
  private Expression left;
  private TokenType operator;
  private Expression right;

  public BinaryExpression(Expression left, TokenType operator, Expression right) {
    this.left = left;
    this.operator = operator;
    this.right = right;
  }

  public void print(StringBuilder sb) {
    sb.append("(");
    sb.append(operator.stringify());
    sb.append(" ");
    left.print(sb);
    sb.append(" ");
    right.print(sb);
    sb.append(")");
  }

  public <R> R accept(Visitor<R> visitor) {
    return visitor.visitBinaryExpression(this);
  }

  public Expression getLeft() {
    return left;
  }

  public TokenType getOperator() {
    return operator;
  }

  public Expression getRight() {
    return right;
  }
}
