package org.example.Expression;

import org.example.Graph.Visitor;

public interface Expression {
  void print(StringBuilder sb);

  public abstract <R> R accept(Visitor<R> visitor);
}
