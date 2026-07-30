package org.example.Graph;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.example.Expression.Expression;

public class ComponentNode {
  String name;
  Expression expr;

  Set<ComponentNode> dependencies;
  Set<ComponentNode> dependents;

  public ComponentNode() {
    this.dependencies = new HashSet<>();
    this.dependents = new HashSet<>();
  }

  public ComponentNode(String name, Expression expr) {
    this.name = name;
    this.expr = expr;
    this.dependencies = new HashSet<>();
    this.dependents = new HashSet<>();
  }

  public void addChild(ComponentNode node) {
    dependencies.add(node);
  }

  public void addDependent(ComponentNode node) {
    dependents.add(node);
  }

  public Set<ComponentNode> getDependents() {
    return dependents;
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

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof ComponentNode))
      return false;
    ComponentNode other = (ComponentNode) obj;
    return Objects.equals(name, other.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
