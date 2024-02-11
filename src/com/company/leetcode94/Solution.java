package com.company.leetcode94;

import com.company.leetcode.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author awmlk
 * @description 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * 思路：
 * 就中序遍历，再复习下前中后序遍历
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderVal = new ArrayList<>();
        inorderFindVal(root, inorderVal);
        return inorderVal;
    }

    private void inorderFindVal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorderFindVal(node.left, list);
        list.add(node.val);
        inorderFindVal(node.right, list);
    }
}
