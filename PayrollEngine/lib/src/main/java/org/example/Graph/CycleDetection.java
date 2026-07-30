package org.example.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CycleDetection {
  public static List<ComponentNode> topologicalSort(Map<String, ComponentNode> node) {
    List<ComponentNode> sortedOrder = new ArrayList<>();
    Queue<ComponentNode> queue = new LinkedList<>();
    Map<String, Integer> inDegree = new HashMap<>();

    for (ComponentNode n : node.values()) {
      int total = n.getDependencies().size();
      inDegree.put(n.getName(), total);

      if (total == 0) {
        queue.add(n);
      }
    }

    while (!queue.isEmpty()) {
      ComponentNode n = queue.poll();
      sortedOrder.add(n);

      for (ComponentNode dep : n.getDependents()) {
        int updatedCount = inDegree.get(dep.getName()) - 1;
        inDegree.put(dep.getName(), updatedCount);

        if (updatedCount == 0) {
          queue.add(dep);
        }
      }
    }

    if (sortedOrder.size() != node.size()) {
      throw new RuntimeException("Graph has a cycle");
    }

    return sortedOrder;
  }
}
