package com.company.leetcode1261;

import com.company.leetcode.BinaryTree.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author JesContes
 * @description some desc
 * @since 2024/3/12
 */
public class FindElementsTest {

    @Test
    public void find() {
        int nodeSize = 5;
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = 0; i < nodeSize; i++) {
            nodes.add(new TreeNode(-1));
        }
        nodes.get(0).left = nodes.get(1);
        nodes.get(0).right = nodes.get(2);
        nodes.get(1).left = nodes.get(3);
        nodes.get(1).right = nodes.get(4);
        FindElements findElements = new FindElements(nodes.get(0));
        assertTrue(findElements.find(0));
        assertTrue(findElements.find(1));
        assertTrue(findElements.find(4));
        assertFalse(findElements.find(5));
        assertFalse(findElements.find(9));
        assertFalse(findElements.find(100));
        assertFalse(findElements.find(-1));
    }
}