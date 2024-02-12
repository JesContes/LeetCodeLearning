package com.company.leetcode145;

import com.company.leetcode.BinaryTree.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void postorderTraversal() {
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = 0; i <= 3; i++) {
            TreeNode node = new TreeNode(i);
            nodes.add(node);
        }
        nodes.get(1).right = nodes.get(2);
        nodes.get(2).left = nodes.get(3);
        Solution solution = new Solution();
        List<Integer> result = solution.postorderTraversal(nodes.get(1));
        assertEquals(3, result.size());
        assertEquals(3, result.get(0).intValue());
        assertEquals(2, result.get(1).intValue());
        assertEquals(1, result.get(2).intValue());
    }
}