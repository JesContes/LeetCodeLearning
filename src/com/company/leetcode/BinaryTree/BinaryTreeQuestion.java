package com.company.leetcode.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Level;

public class BinaryTreeQuestion {
    //109. 有序链表转换二叉搜索树
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null){
            return null;
        }
        TreeNode root = addChildren(head, null);
        return root;
    }

    public ListNode findTheMid(ListNode Lns, ListNode Lne){
        if (Lns == Lne){
            return null;
        }
        ListNode SlowNode = Lns, FastNode = Lns;
        while (FastNode != Lne && FastNode.next != Lne){
            FastNode = FastNode.next.next;
            SlowNode = SlowNode.next;
        }
        return SlowNode;
    }

    public TreeNode addChildren(ListNode Lns, ListNode Lne){
        if (Lns == Lne){
            return null;
        }
        ListNode mid = findTheMid(Lns, Lne);
        TreeNode root = new TreeNode(mid.val);
        root.left = addChildren(Lns, mid);
        root.right = addChildren(mid.next, Lne);
        return root;
    }
}
