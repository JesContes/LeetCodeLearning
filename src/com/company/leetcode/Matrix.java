package com.company.leetcode;

import java.util.*;

public class Matrix {
    //130. 被围绕的区域
    public void solve(char[][] board) {
        if (board.length == 0){
            return;
        }
        for (int j = 0; j < board[0].length; j++){
            if (board[0][j] == 'O') {
                SignArea(Aspect.DOWN, board, 0, j);
            }
            if (board[board.length - 1][j] == 'O') {
                SignArea(Aspect.UP, board, board.length - 1, j);
            }
        }
        for (int i = 1; i < board.length - 1; i++){
            if (board[i][0] == 'O') {
                SignArea(Aspect.RIGHT, board, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                SignArea(Aspect.LEFT, board, i, board[0].length - 1);
            }
        }
        printX(board);
    }

    private enum Aspect{
        LEFT, RIGHT, UP, DOWN
    }

    private void SignArea(Aspect Asp, char[][] board, int x, int y){
        if (board[x][y] == 'O'){
            board[x][y] = 'A';
        } else {
            return;
        }
        if (Asp != Aspect.LEFT && y < board[0].length - 1){
            SignArea(Aspect.RIGHT, board, x, y + 1);
        }
        if (Asp != Aspect.RIGHT && y > 0 ){
            SignArea(Aspect.LEFT, board, x, y - 1);
        }
        if (Asp != Aspect.UP && x < board.length - 1){
            SignArea(Aspect.DOWN, board, x + 1, y);
        }
        if (Asp != Aspect.DOWN && x > 0){
            SignArea(Aspect.UP, board, x - 1, y);
        }
    }

    private void printX(char[][] board){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 'A'){
                    board[i][j] = 'O';
                }
                else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    //529. 扫雷游戏
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]] = 'X';
            return board;
        }
        else if (board[click[0]][click[1]]!='E'){
            return board;
        }
        char[][] resBoard = showEmptyArea(board, click[1], click[0]);
        return resBoard;
    }

    public char[][] showEmptyArea(char[][] board, int Xpos, int Ypos){
        if (Xpos < 0||Xpos >= board[0].length||Ypos < 0||Ypos >= board.length||board[Ypos][Xpos]!='E'){
            return board;
        }
        int MineNum = countMines(board, Xpos, Ypos);
        if (MineNum == 0){
            board[Ypos][Xpos] = 'B';
            board = showEmptyArea(board, Xpos - 1, Ypos);
            board = showEmptyArea(board, Xpos, Ypos - 1);
            board = showEmptyArea(board, Xpos + 1, Ypos);
            board = showEmptyArea(board, Xpos, Ypos + 1);
        }
        else {
            board[Ypos][Xpos] = (char) ('0' + MineNum);
        }
        return board;
    }

    public int countMines(char[][] board, int Xpos, int Ypos){
        int Xlength = board[0].length;
        int Ylength = board.length;
        int Sum = 0;
        for (int j = Xpos - 1; j <= Xpos + 1; j++){
            if (j >= 0 && j < Xlength) {
                for (int i = Ypos - 1; i <= Ypos + 1; i++) {
                    if (i == Ypos && j == Xpos) {
                        continue;
                    }
                    if (i >= 0 && i < Ylength && board[i][j] == 'M') {
                        Sum++;
                    }
                }
            }
        }
        return Sum;
    }

    //841. 钥匙和房间
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.size() == 1){
            return true;
        }
        Set<String> OpenedRooms = new HashSet<>();
        Queue<Integer> CanBeUsedKeys = new LinkedList<>();
        OpenedRooms.add("0");
        for (Integer OneRoomKeys : rooms.get(0)){
            if (!OpenedRooms.contains(OneRoomKeys.toString())){
                OpenedRooms.add(OneRoomKeys.toString());
                CanBeUsedKeys.add(OneRoomKeys);
            }
        }
        getIntoRooms(CanBeUsedKeys, OpenedRooms, rooms);
        return rooms.size() == OpenedRooms.size();
    }

    public void getIntoRooms(Queue<Integer> CanBeUsedKeys, Set<String> OpenedRooms, List<List<Integer>> rooms){
        if (CanBeUsedKeys.size() == 0){
            return;
        }
        while (CanBeUsedKeys.size() > 0){
            Integer DoorPlate = CanBeUsedKeys.poll();
            for (Integer OneRoomKeys : rooms.get(DoorPlate)){
                if (!OpenedRooms.contains(OneRoomKeys.toString())){
                    OpenedRooms.add(OneRoomKeys.toString());
                    CanBeUsedKeys.add(OneRoomKeys);
                }
            }
        }
        getIntoRooms(CanBeUsedKeys, OpenedRooms, rooms);
    }

    //51. N 皇后
    public List<List<String>> solveNQueens(int n) {
        Set<Integer> X = new HashSet<>();
        Set<Integer> Front = new HashSet<>();
        Set<Integer> Back = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        List<String> OneSolution = new ArrayList<>();
        findOneLineQ(res, X, Front, Back, n, 0, OneSolution);
        return res;
    }

    public void findOneLineQ(List<List<String>> res, Set<Integer> X, Set<Integer> Front, Set<Integer> Back, int n, int j, List<String> OneSolution){
        if (j == n){
            res.add(OneSolution);
            return;
        }
        for (int i = 0; i < n; i++){
            if(!X.contains(i) && !Front.contains(j+i) && !Back.contains(j - i)){
                char[] OneLine = new char[n];
                for (int LineIndex = 0; LineIndex < n; LineIndex++){
                    OneLine[LineIndex] = '.';
                }
                OneLine[i] = 'Q';
                List<String> OneSolutionTemp = new ArrayList<>(OneSolution);
                OneSolutionTemp.add(new String(OneLine));
                X.add(i);
                Front.add(j + i);
                Back.add(j - i);
                findOneLineQ(res, X, Front, Back, n, j + 1, OneSolutionTemp);
                X.remove(i);
                Front.remove(j + i);
                Back.remove(j - i);
            }
        }
    }
}
