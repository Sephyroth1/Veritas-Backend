package org.example.Graph;

import java.util.HashSet;
import java.util.Set;

import org.example.Expression.Expression;

public class ComponentNode {
  String name;
  Expression expr;

  Set<ComponentNode> dependencies;

  public ComponentNode() {
    this.dependencies = new HashSet<>();
  }

  public ComponentNode(String name, Expression expr) {
    this.name = name;
    this.expr = expr;
    this.dependencies = new HashSet<>();
  }

  public void addChild(ComponentNode node) {
    dependencies.add(node);
  }

  public Expression getExpression() {
    return expr;
  }

  public String getName() {
    return name;
  }
    
  public Set<ComponentNode> getDependencies() {
      return dependencies;
  }
}
