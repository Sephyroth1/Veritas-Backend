package org.example.Expression;

import org.example.Graph.Visitor;
import org.example.Utils.TokenType;

public class PrefixExpression implements Expression {
  private Expression right;
  private TokenType operator;

  public PrefixExpression(Expression right, TokenType operator) {
    this.right = right;
    this.operator = operator;
  }

  public void print(StringBuilder sb) {
    sb.append("(");
    sb.append(operator.stringify());
    sb.append(" ");
    right.print(sb);
    sb.append(")");
  }

  public <R> R accept(Visitor<R> visitor) {
    return visitor.visitPreFixExpression(this);
  }

  public Expression getRight() {
    return right;
  }

  public TokenType getOperator() {
    return operator;
  }
}
