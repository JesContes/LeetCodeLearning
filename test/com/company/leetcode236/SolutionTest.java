package com.company.leetcode236;

import com.company.leetcode.BinaryTree.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void lowestCommonAncestor() {
        List<TreeNode> nodeList = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            nodeList.add(new TreeNode(i));
        }
        nodeList.get(3).left = nodeList.get(5);
        nodeList.get(3).right = nodeList.get(1);
        nodeList.get(5).left = nodeList.get(6);
        nodeList.get(5).right = nodeList.get(2);
        nodeList.get(2).left = nodeList.get(7);
        nodeList.get(2).right = nodeList.get(4);
        nodeList.get(1).left = nodeList.get(0);
        nodeList.get(1).right = nodeList.get(8);
        Solution solution = new Solution();
        TreeNode result = solution.lowestCommonAncestor(nodeList.get(3), nodeList.get(5), nodeList.get(1));
        assertEquals(3, result.val);
    }
}