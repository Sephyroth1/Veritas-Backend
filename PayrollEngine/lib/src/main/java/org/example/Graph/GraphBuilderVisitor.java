package org.example.Graph;

import java.util.HashMap;
import java.util.Map;

import org.example.Expression.AssignExpression;
import org.example.Expression.BinaryExpression;
import org.example.Expression.Expression;
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
    if (node == null) {
      throw new RuntimeException("Name cannot be null");
    }

    ComponentNode node1 = nodes.get(node.getName());

    if (node1 == null) {
      throw new RuntimeException("Name " + node.getName() + " not found");
    }

    current.addChild(node1);
    node1.addDependent(current);
    return null;
  }

  @Override
  public Void visitAssignExpression(AssignExpression node) {
    if (node == null) {
      throw new RuntimeException("Assign expression cannot be null");
    }
    Expression left = node.getName();
    if (!(left instanceof NameExpression)) {
      throw new RuntimeException("Left side of assignment must be a name");
    }

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
    if (node == null) {
      throw new RuntimeException("Prefix expression cannot be null");
    }
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
