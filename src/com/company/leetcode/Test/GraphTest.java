package com.company.leetcode.Test;

import com.company.leetcode.Graph.Graph;
import com.company.leetcode.Graph.Node;

public class GraphTest {
    public void cloneGraphTest(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        Graph graph = new Graph();
        Node nodecopy = graph.cloneGraph(null);
        System.out.println(nodecopy);
    }
}
