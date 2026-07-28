package org.example.Graph;

import java.util.HashMap;
import java.util.Map;

import org.example.Expression.AssignExpression;
import org.example.Expression.BinaryExpression;
import org.example.Expression.NameExpression;
import org.example.Expression.NumberExpression;
import org.example.Expression.PostfixExpression;
import org.example.Expression.PrefixExpression;

public class GraphBuilderVisitor implements Visitor<Void> {
  private Map<String, ComponentNode> nodes;
  private ComponentNode current;

  public GraphBuilderVisitor(Map<String, ComponentNode> nodes) {
    this.nodes = nodes;
  }

  @Override
  public Void visitBinaryExpression(BinaryExpression node) {
    node.getLeft().accept(this);
    node.getRight().accept(this);
    return null;
  }

  @Override
  public Void visitNameExpression(NameExpression node) {
    ComponentNode node1 = nodes.get(node.getName());

    if (node1 != null) {
      current.addChild(node1);
    }

    return null;
  }

  @Override
  public Void visitAssignExpression(AssignExpression node) {
    current = nodes.get(node.getName().getName());

    node.getRight().accept(this);

    return null;
  }

  @Override
  public Void visitNumberExpression(NumberExpression node) {
    return null;
  }

  @Override
  public Void visitPreFixExpression(PrefixExpression node) {
    node.getRight().accept(this);
    return null;
  }

  @Override
  public Void visitPostFixExpression(PostfixExpression node) {
    node.getLeft().accept(this);
    return null;
  }

  public void setCurrent(ComponentNode node) {
    this.current = node;
  }
}
