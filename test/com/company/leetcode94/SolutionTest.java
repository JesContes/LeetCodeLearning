package com.company.leetcode94;

import com.company.leetcode.BinaryTree.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void inorderTraversal() {
        List<TreeNode> nodeList = new ArrayList<>();
        for (int i = 0; i <= 3; i++) {
            nodeList.add(new TreeNode(i));
        }
        nodeList.get(1).right = nodeList.get(2);
        nodeList.get(2).left = nodeList.get(3);
        Solution solution = new Solution();
        List<Integer> result = solution.inorderTraversal(nodeList.get(1));
        assertEquals(3, result.size());
        assertEquals(1, result.get(0).intValue());
        assertEquals(3, result.get(1).intValue());
        assertEquals(2, result.get(2).intValue());
    }
}