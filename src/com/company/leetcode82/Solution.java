package com.company.leetcode82;

import com.company.leetcode.BinaryTree.ListNode;

/**
 * @author JesContes
 * @description 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * 思路：
 * 先虚拟一个头节点，然后设置节点索引A，检测A和A的下一个节点的值是否相等，如果相等则记录A的值，并去除A点，一直去除到A点索引位的值大于记录值，不断循环这个操作，直到遍历到链表尾部
 * @since 2024/1/15
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode virtualHead = new ListNode(0);
        virtualHead.next = head;
        ListNode pre = virtualHead;
        ListNode node = head;
        // 设置比最小的val还要小的初始值，方便进循环根据条件重赋值
        int repeatVal = -101;
        while (node != null) {
            if (repeatVal == node.val) {
                node = node.next;
                pre.next = node;
            } else if (node.next == null) {
                break;
            } else if (node.val == node.next.val) {
                repeatVal = node.val;
            } else {
                pre = node;
                node = node.next;
            }
        }
        return virtualHead.next;
    }
}
