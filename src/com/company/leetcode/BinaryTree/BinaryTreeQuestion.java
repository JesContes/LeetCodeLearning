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

    /*257. 二叉树的所有路径
        date: 2020-09-04
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        findBinaryTreePath(res, String.valueOf(root.val), root);
        return res;
    }

    public void findBinaryTreePath(List<String> Paths, String OnePath, TreeNode Point){
        if (Point.left == null && Point.right == null){
            Paths.add(OnePath);
            return;
        }
        if (Point.left != null) {
            findBinaryTreePath(Paths, OnePath + "->" + Point.left.val, Point.left);
        }
        if (Point.right != null) {
            findBinaryTreePath(Paths, OnePath + "->" + Point.right.val, Point.right);
        }
    }
}
