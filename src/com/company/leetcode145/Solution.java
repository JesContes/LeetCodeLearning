package com.company.leetcode145;

import com.company.leetcode.BinaryTree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author awmlk
 * @description 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * 思路：
 * 用迭代算法，创建一个栈，先一直压左叶子节点进栈，直到左叶子为空，就可以添加到队列，pop新节点时，判断上一个节点是左子节点还是右叶子，
 * 如果是左叶子，就把右叶子进栈，否则出栈
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode prev = root;
        stack.push(root);
        while (!stack.isEmpty()) {
            if (prev.equals(stack.peek())) {
                if (stack.peek().left != null) {
                    prev = stack.peek().left;
                    stack.push(prev);
                } else if (stack.peek().right != null) {
                    prev = stack.peek().right;
                    stack.push(prev);
                } else {
                    stack.pop();
                    result.add(prev.val);
                }
            } else if (prev.equals(stack.peek().left)) {
                if (stack.peek().right != null) {
                    prev = stack.peek().right;
                    stack.push(prev);
                } else {
                    prev = stack.pop();
                    result.add(prev.val);
                }
            } else {
                prev = stack.pop();
                result.add(prev.val);
            }
        }
        return result;
    }
}
