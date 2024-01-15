package com.company.leetcode82;

import com.company.leetcode.BinaryTree.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author JesContes
 * @description some desc
 * @since 2024/1/15
 */
public class SolutionTest {

    @Test
    public void deleteDuplicates() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        Solution solution = new Solution();
        head = solution.deleteDuplicates(head);
        assertEquals(1, head.val);
        head = head.next;
        assertEquals(2, head.val);
        head = head.next;
        assertEquals(5, head.val);
        assertNull(head.next);
    }

    @Test
    public void deleteDuplicates_2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        Solution solution = new Solution();
        head = solution.deleteDuplicates(head);
        assertNull(head);
    }
}