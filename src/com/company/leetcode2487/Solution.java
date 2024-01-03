package com.company.leetcode2487;

import com.company.leetcode.BinaryTree.ListNode;

import java.util.Stack;

/**
 * @author JesContes
 * @description 给你一个链表的头节点 head 。移除每个右侧有一个更大数值的节点。返回修改后链表的头节点 head 。
 * 思路：
 * 老遍历人了
 * 从左往右不停循环遍历会超时，因为需要不断从头循环处理可能的变化，移除某个节点后对前面已经处理过的节点会产生重复影响
 * 考虑使用递归或者单调栈，这样相当于优先处理右侧，这样避免重复处理左侧节点，本次就先用单调栈吧
 * @since 2024/1/3
 */
public class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode virtualHead = new ListNode(0);
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            if (virtualHead.next == null) {
                virtualHead.next = node;
            } else {
                if (virtualHead.next.val <= node.val) {
                    node.next = virtualHead.next;
                    virtualHead.next = node;
                }
            }
        }
        return virtualHead.next;
    }
}
