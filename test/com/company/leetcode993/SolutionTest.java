package com.company.leetcode993;

import com.company.leetcode.BinaryTree.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void isCousins() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        int x = 2;
        int y = 3;
        Solution solution = new Solution();
        boolean result = solution.isCousins(root, x, y);
        assertFalse(result);
    }

    @Test
    public void isCousins_2() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node2.right = node4;
        int x = 5;
        int y = 4;
        Solution solution = new Solution();
        boolean result = solution.isCousins(root, x, y);
        assertTrue(result);
    }
}