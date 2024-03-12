package com.company.leetcode1261;

import com.company.leetcode.BinaryTree.TreeNode;

import java.util.*;

/**
 * @author JesContes
 * @description 给出一个满足下述规则的二叉树：
 * root.val == 0
 * 如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 1
 * 如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x + 2
 * 现在这个二叉树受到「污染」，所有的 treeNode.val 都变成了 -1。
 * 请你先还原二叉树，然后实现 FindElements 类：
 * FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。
 * bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果。
 * @since 2024/3/12
 */
public class FindElements {
    private TreeNode findRoot;
    private final Set<Integer> values = new HashSet<>();

    public FindElements(TreeNode root) {
        findRoot = root;
        if (root == null) {
            return;
        }
        Deque<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        root.val = 0;
        values.add(0);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            while (size > 0) {
                TreeNode node = nodes.pollFirst();
                size--;
                if (node == null) {
                    continue;
                }
                values.add(node.val);
                if (node.left != null) {
                    node.left.val = node.val * 2 + 1;
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2 + 2;
                    nodes.add(node.right);
                }
            }
        }
    }

    public boolean find(int target) {
        return values.contains(target);
    }
}
