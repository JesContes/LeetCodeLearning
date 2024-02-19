package com.company.leetcode590;

import com.company.leetcode.BinaryTree.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author JesContes
 * @description some desc
 * @since 2024/2/19
 */
public class SolutionTest {

    @Test
    public void postorder() {
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
        List<Integer> expected = Arrays.asList(5,6,3,2,4,1);
        Solution solution = new Solution();
        List<Integer> result = solution.postorder(nodeList.get(1));
        assertEquals(6, result.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).intValue(), result.get(i).intValue());
        }
    }
}