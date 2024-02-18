package com.company.leetcode.BinaryTree;

import java.util.List;

/**
 * @author JesContes
 * @description some desc
 * @since 2024/2/18
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
