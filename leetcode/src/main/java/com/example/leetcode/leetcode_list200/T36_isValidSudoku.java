package com.example.leetcode.leetcode_list200;

import java.util.HashMap;

/**
 * Author:cafe3165
 * Date:2020-01-13
 */
public class T36_isValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        HashMap<Character, Integer>[] rows = new HashMap[9];
        HashMap<Character, Integer>[] cols = new HashMap[9];
        HashMap<Character, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]!='.'){
                    int box_index = (i / 3) * 3 + j / 3;
                    rows[i].put(board[i][j], rows[i].getOrDefault(board[i][j], 0) + 1);
                    cols[j].put(board[i][j], cols[j].getOrDefault(board[i][j], 0) + 1);
                    boxes[box_index].put(board[i][j], boxes[box_index].getOrDefault(board[i][j], 0) + 1);

//                check
                    if(rows[i].get(board[i][j])>1||cols[j].get(board[i][j])>1||boxes[box_index].get(board[i][j])>1){
                        return false;
                    }
                }


            }
        }

    return true;
    }

    public static void main(String[] args) {
        T36_isValidSudoku t = new T36_isValidSudoku();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(t.isValidSudoku(board));

    }

}
