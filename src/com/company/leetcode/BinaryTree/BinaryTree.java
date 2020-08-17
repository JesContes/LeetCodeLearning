package com.company.leetcode.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public int val;
    public BinaryTree LChild;
    public BinaryTree RChild;

    public BinaryTree createBinaryTree(String[] ValList){
        Queue<BinaryTree> T = new LinkedList<BinaryTree>();
        BinaryTree root;
        int ListIndex = 1;
        if (ValList.length == 0){
            return null;
        }
        root = new BinaryTree(ValList[0]);
        T.add(root);
        while(!T.isEmpty()&&ListIndex < ValList.length){
            BinaryTree tmp = T.poll();
            if (ValList[ListIndex] == "#"){
                tmp.LChild = null;
            }
            else {
                tmp.LChild = new BinaryTree(ValList[ListIndex]);
                T.add(tmp.LChild);
            }
            ListIndex++;
            if (ListIndex == ValList.length){
                break;
            }
            if (ValList[ListIndex] == "#"){
                tmp.RChild = null;
            }
            else {
                tmp.RChild = new BinaryTree(ValList[ListIndex]);
                T.add(tmp.RChild);
            }
            ListIndex++;
        }
        return root;
    }

    public BinaryTree(String val){
        try{
            this.val = Integer.parseInt(val);
            this.LChild = null;
            this.RChild = null;
        } catch (NumberFormatException e){
            System.out.println("非法数字："+val);
        }
    }

    public BinaryTree(){

    }
}
