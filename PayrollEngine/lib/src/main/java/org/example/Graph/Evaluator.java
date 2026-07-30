package org.example.Graph;

import java.math.BigDecimal;
import java.util.Map;

import org.example.Expression.AssignExpression;
import org.example.Expression.BinaryExpression;
import org.example.Expression.NameExpression;
import org.example.Expression.NumberExpression;
import org.example.Expression.PostfixExpression;
import org.example.Expression.PrefixExpression;
import org.example.Utils.TokenType;

public class Evaluator implements Visitor<BigDecimal> {
  private Map<String, BigDecimal> values;

  public Evaluator(Map<String, BigDecimal> values) {
    this.values = values;
  }

  @Override
  public BigDecimal visitBinaryExpression(BinaryExpression node) {
    BigDecimal left = node.getLeft().accept(this);
    BigDecimal right = node.getRight().accept(this);
    switch (node.getOperator()) {
      case TokenType.ADD:
        return left.add(right);
      case TokenType.SUB:
        return left.subtract(right);
      case TokenType.MUL:
        return left.multiply(right);
      case TokenType.DIV:
        if (right.equals(BigDecimal.ZERO)) {
          throw new RuntimeException("Division by zero");
        }
        return left.divide(right);
      default:
        throw new UnsupportedOperationException("Unsupported operator");
    }
  }

  @Override
  public BigDecimal visitNameExpression(NameExpression node) {
    if (!values.containsKey(node.getName())) {
      throw new RuntimeException("Undefined variable");
    }

    String var = node.getName();
    return values.get(var);
  }

  @Override
  public BigDecimal visitNumberExpression(NumberExpression node) {
    return node.getValue();
  }

  @Override
  public BigDecimal visitPostFixExpression(PostfixExpression node) {
    BigDecimal value = node.getLeft().accept(this);

    return value;
  }

  @Override
  public BigDecimal visitPreFixExpression(PrefixExpression node) {
    BigDecimal value = node.getRight().accept(this);
    switch (node.getOperator()) {
      case TokenType.SUB:
        return value.negate();
    }
    return value;
  }

  @Override
  public BigDecimal visitAssignExpression(AssignExpression node) {
    String key = node.getName().getName();
    BigDecimal value = node.getRight().accept(this);
    values.put(key, value);
    return value;
  }
}
