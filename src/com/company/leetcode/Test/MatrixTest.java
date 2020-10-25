package com.company.leetcode.Test;

import com.company.leetcode.Matrix;

import java.rmi.MarshalException;
import java.util.List;

public class MatrixTest {
    public void MatrixSolveTest(){
        char[][] board = new char[][]{{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        Matrix Mx = new Matrix();
        Mx.solve(board);
        System.out.println(board);
    }

    public void solveNQueensTest(){
        Matrix Mx = new Matrix();
        int n = 2;
        List<List<String>> res = Mx.solveNQueens(n);
        System.out.println(res);
    }

    public void minimumEffortPathTest(){
        Matrix Mx = new Matrix();
        int[][] heights  = new int[][]{{1,2,3},{3,8,4},{5,3,5}};
        System.out.println(Mx.minimumEffortPath(heights));
    }
}
