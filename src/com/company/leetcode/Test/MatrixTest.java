package com.company.leetcode.Test;

import com.company.leetcode.Matrix;

public class MatrixTest {
    public void MatrixSolveTest(){
        char[][] board = new char[][]{{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        Matrix Mx = new Matrix();
        Mx.solve(board);
        System.out.println(board);
    }
}
