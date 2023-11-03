package com.company.leetcode117;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author awmlk
 */
public class Solution {
    public Node connect(Node root) {
        Map<Integer, List<Node>> layerNodeMap = new HashMap<>();
        recordeNode(layerNodeMap, 1, root);
        for (List<Node> tempNode : layerNodeMap.values()) {
            for (int i = 0; i < tempNode.size() - 1; i++) {
                tempNode.get(i).next = tempNode.get(i + 1);
            }
        }
        return root;
    }

    /**
     * 记录每一层的node
     *
     * @param nodeMap 每层node记录的哈希表
     * @param layerNumber 层数
     * @param node 当前节点
     */
    private void recordeNode(Map<Integer, List<Node>> nodeMap, Integer layerNumber, Node node) {
        if (node == null) {
            return;
        }
        if (!nodeMap.containsKey(layerNumber)) {
            nodeMap.put(layerNumber, new ArrayList<>());
        }
        nodeMap.get(layerNumber).add(node);
        recordeNode(nodeMap, layerNumber + 1, node.left);
        recordeNode(nodeMap, layerNumber + 1, node.right);
    }
}
