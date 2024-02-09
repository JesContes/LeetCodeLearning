package com.company.leetcode993;

import com.company.leetcode.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author awmlk
 * @description 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 * 思路：
 * 递归查找，都查找到后对比深度,用广度优先遍历，这样如果循环到下一层就可以直接返回false了
 */
public class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        List<TreeNode> layerNodes = new LinkedList<>();
        List<Integer> parentRecord = new LinkedList<>();
        layerNodes.add(root);
        parentRecord.add(-1);
        int parentX = -1;
        int parentY = -1;
        while (!layerNodes.isEmpty()) {
            int removeNodes = layerNodes.size();
            for (int i = 0; i < removeNodes; i++) {
                TreeNode node = layerNodes.remove(0);
                int parent = parentRecord.remove(0);
                if (node.val == x) {
                    parentX = parent;
                }
                if (node.val == y) {
                    parentY = parent;
                }
                if (node.left != null) {
                    layerNodes.add(node.left);
                    parentRecord.add(node.val);
                }
                if (node.right != null) {
                    layerNodes.add(node.right);
                    parentRecord.add(node.val);
                }
            }
            if (parentX == -1 && parentY == -1) {
                continue;
            }
            return parentX > -1 && parentY > -1 && parentX != parentY;
        }
        return false;
    }
}
