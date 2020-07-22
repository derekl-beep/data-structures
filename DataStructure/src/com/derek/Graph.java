package com.derek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjancencyList = new HashMap<>();

    public void addNode(String label) {
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjancencyList.putIfAbsent(node, new ArrayList<Node>());
    }

    public void addEdge(String from, String to) {
        var fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();

        // add toNode to the adjancencyList of fromNode
        adjancencyList.get(fromNode).add(toNode);
    }

    public void print() {
     for (var source : adjancencyList.keySet()) {
         var targets = adjancencyList.get(source);
         if (!targets.isEmpty())
             System.out.println(source + " is connected to " + targets);
     }
    }

    public void removeNode(String label) {
        var node = nodes.get(label);

        if (node == null)
            return;

        for (var source : adjancencyList.keySet())
            adjancencyList.get(source).remove(node);

        adjancencyList.remove(node);
        nodes.remove(label);
    }

    public void removeEdge(String from, String to) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        if (fromNode == null || toNode == null)
            return;

        adjancencyList.get(fromNode).remove(toNode);
    }


}
