package com.company.leetcode589;
import com.company.leetcode.BinaryTree.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author JesContes
 * @description 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * 思路：
 * 迭代法
 * @since 2024/2/18
 */
public class Solution {
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<Node> stack = new Stack<>();
        Stack<Integer> nodeIndex = new Stack<>();
        stack.push(root);
        nodeIndex.push(-1);
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        while (!stack.isEmpty()) {
            Node node = stack.peek();
            if (node.children == null || node.children.isEmpty()) {
                nodeIndex.pop();
                stack.pop();
            } else {
                int index = nodeIndex.pop() + 1;
                if (index >= node.children.size()) {
                    stack.pop();
                } else {
                    nodeIndex.push(index);
                    nodeIndex.push(-1);
                    stack.push(node.children.get(index));
                    result.add(stack.peek().val);
                }
            }
        }
        return result;
    }
}
