package com.company.leetcode1038;

import com.company.leetcode.BinaryTree.TreeNode;

/**
 * @author awmlk
 * 从二叉搜索树到更大和树
 * 思路：
 * 类似中序遍历，先访问右子树，再访问自身，再访问左子树
 * 深度优先，叠加上来就行
 */
public class Solution {
    /**
     * 从二叉搜索树到更大和树
     *
     * @param root 二叉搜索树根节点
     * @return 更大和数根节点
     */
    public TreeNode bstToGst(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    /**
     * 遍历计算
     *
     * @param node 当前节点
     * @param tempSum 当前和
     * @return 遍历之后的和
     */
    private int dfs(TreeNode node, int tempSum) {
        if (node == null) {
            return tempSum;
        }
        int newSum = dfs(node.right, tempSum);
        node.val += newSum;
        return dfs(node.left, node.val);
    }
}
