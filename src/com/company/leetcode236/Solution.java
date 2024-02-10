package com.company.leetcode236;

import com.company.leetcode.BinaryTree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author awmlk
 * @description 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 思路：
 * 深度遍历查找左右子树，如果查找到了两个节点，则记录当前节点，第一个记录的节点即为最近公共祖先
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> commonParentNode = new ArrayList<>();
        findNode(root, p, q, commonParentNode);
        return commonParentNode.get(0);
    }

    private boolean[] findNode(TreeNode node, TreeNode p, TreeNode q, List<TreeNode> commonParentNode) {
        if (node == null) {
            return new boolean[]{false, false};
        }
        boolean[] findResLeft = findNode(node.left, p, q, commonParentNode);
        boolean[] findResRight = findNode(node.right, p, q, commonParentNode);
        boolean[] findRes = new boolean[2];
        findRes[0] = findResLeft[0] || findResRight[0];
        findRes[1] = findResLeft[1] || findResRight[1];
        if (node.val == p.val) {
            findRes[0] = true;
        }
        if (node.val == q.val) {
            findRes[1] = true;
        }
        if (findRes[0] && findRes[1] && commonParentNode.isEmpty()) {
            commonParentNode.add(node);
        }
        return findRes;
    }
}
