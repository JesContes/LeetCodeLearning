package com.company.leetcode.Graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    //133. 克隆图
    public Node cloneGraph(Node node) {
        List<Node> nodeList = new ArrayList<>();
        List<Integer> nodeValList = new ArrayList<>();
        Node nodecopy = new Node();
        if (checkNodeNull(node)) {
            for (int i = 1; i <= 100; i++) {
                nodeList.add(new Node(i));
            }
            findNeighbor(node, nodeList, nodeValList);
            nodecopy = nodeList.get(node.val - 1);
            return nodecopy;
        } else {
            return null;
        }

    }

    private void findNeighbor(Node node, List<Node> nodeList, List<Integer> nodeValList){
        nodeValList.add(node.val);
        for (Node nodeNeighbor : node.neighbors){
            nodeList.get(node.val - 1).neighbors.add(nodeList.get(nodeNeighbor.val - 1));
            if (!nodeValList.contains(nodeNeighbor.val)){
                findNeighbor(nodeNeighbor, nodeList, nodeValList);
            }
        }
    }

    private boolean checkNodeNull(Node node){
        if (node == null){
            return false;
        }
        else {
            return true;
        }
    }
}
