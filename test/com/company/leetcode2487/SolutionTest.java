package com.company.leetcode2487;

import com.company.leetcode.BinaryTree.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author JesContes
 * @description some desc
 * @since 2024/1/3
 */
public class SolutionTest {

    @Test
    public void removeNodes() {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(13);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Solution solution = new Solution();
        ListNode node = solution.removeNodes(node1);
        assertEquals(13, node.val);
        node = node.next;
        assertEquals(8, node.val);
        assertNull(node.next);
    }
}