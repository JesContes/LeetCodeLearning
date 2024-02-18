package com.company.leetcode589;

import com.company.leetcode.BinaryTree.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author JesContes
 * @description some desc
 * @since 2024/2/18
 */
public class SolutionTest {

    @Test
    public void preorder() {
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Node node = new Node(i, new ArrayList<>());
            nodeList.add(node);
        }
        nodeList.get(1).children.add(nodeList.get(3));
        nodeList.get(1).children.add(nodeList.get(2));
        nodeList.get(1).children.add(nodeList.get(4));
        nodeList.get(3).children.add(nodeList.get(5));
        nodeList.get(3).children.add(nodeList.get(6));
        Solution solution = new Solution();
        List<Integer> result = solution.preorder(nodeList.get(1));
        assertEquals(6, result.size());
        assertEquals(1, result.get(0).intValue());
        assertEquals(3, result.get(1).intValue());
        assertEquals(5, result.get(2).intValue());
        assertEquals(6, result.get(3).intValue());
        assertEquals(2, result.get(4).intValue());
        assertEquals(4, result.get(5).intValue());
    }
}