package com.example.leetcode.leetcode_daily;

import javax.swing.*;

/**
 * Author:cafe3165
 * Date:2020-03-29
 */
public class T130_graph {
    public static char[][] Board;
    public static int Rows;
    public static int Cols;
    public static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};


    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        Rows = board.length;
        Cols = board[0].length;
        Board = board;

        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Cols; j++) {
                boolean edge = i == 0 || i == Rows - 1 || j == 0 || j == Cols - 1;
                if (edge && Board[i][j] == 'O') {
                    dfs(i, j);
                }
            }
        }

        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Cols; j++) {
                if(Board[i][j]=='O'){
                    Board[i][j]='X';
                }
            }
        }
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Cols; j++) {
                if(Board[i][j]=='#'){
                    Board[i][j]='O';
                }
            }
        }


    }

    public static void dfs(int x, int y) {
        Board[x][y] = '#';
        for (int[] d : dir) {
            int newx = x + d[0];
            int newy = y + d[1];
            if (newx > 0 && newx < Rows - 1 && newy > 0 && newy < Cols - 1 && Board[newx][newy] == 'O') {
                dfs(newx, newy);
            }
        }

    }


    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        T130_graph t = new T130_graph();
        t.solve(board);
    }
}
