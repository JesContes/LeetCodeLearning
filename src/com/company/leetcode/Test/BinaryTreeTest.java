package com.company.leetcode.Test;

import com.company.leetcode.BinaryTree.BinaryTree;
import com.company.leetcode.BinaryTree.BinaryTreeQuestion;
import com.company.leetcode.BinaryTree.ListNode;
import com.company.leetcode.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTest {
    public BinaryTree BinaryTreeCreateTest(String[] ValList) {
        BinaryTree T = new BinaryTree();
        BinaryTree root = T.createBinaryTree(ValList);
        return root;
    }

    public void sortedListToBSTTest(){
        BinaryTreeQuestion Bq = new BinaryTreeQuestion();
        int[] IntList = new int[]{-10, -3, 0, 5, 9};
        ListNode Ln = null;
        ListNode head = null;
        for (int i = 0; i < IntList.length; i++){
            ListNode temp = new ListNode(IntList[i]);
            if (Ln == null){
                Ln = temp;
                head = temp;
            }
            else {
                Ln.next = temp;
                Ln = temp;
            }
        }
        TreeNode Tn = Bq.sortedListToBST(head);
    }
}
