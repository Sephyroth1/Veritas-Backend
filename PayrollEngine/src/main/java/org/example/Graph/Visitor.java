package org.example.Graph;

import org.example.Expression.AssignExpression;
import org.example.Expression.BinaryExpression;
import org.example.Expression.NameExpression;
import org.example.Expression.NumberExpression;
import org.example.Expression.PostfixExpression;
import org.example.Expression.PrefixExpression;

public interface Visitor<R> {

  public R visitBinaryExpression(BinaryExpression node);

  public R visitNameExpression(NameExpression node);

  public R visitNumberExpression(NumberExpression node);

  public R visitPostFixExpression(PostfixExpression node);
  public R visitPreFixExpression(PrefixExpression node);
  public R visitAssignExpression(AssignExpression node);
}
