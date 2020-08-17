package com.company.leetcode.Test;

import com.company.leetcode.BinaryTree.BinaryTree;

public class BinaryTreeTest {
    public BinaryTree BinaryTreeCreateTest(String[] ValList) {
        BinaryTree T = new BinaryTree();
        BinaryTree root = T.createBinaryTree(ValList);
        return root;
    }
}
