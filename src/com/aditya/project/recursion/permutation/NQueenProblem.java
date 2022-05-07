package com.aditya.project.recursion.permutation;

import java.util.ArrayList;
import java.util.List;

//Time Complexity: O( N2 )
//Space Complexity: O( N2 )
public class NQueenProblem {

    public static void main(String[] args) {
        int n = 4;
        System.out.println("n : " + n);
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        boolean[] leftRow = new boolean[n];
        boolean[] lowerDiagonal = new boolean[2 * n - 1];
        boolean[] upperDiagonal = new boolean[2 * n - 1];
        List<List<String>> res = new ArrayList<>();
        solveNQueenProblem(0, board, leftRow, lowerDiagonal, upperDiagonal, res);
        System.out.println(res);
    }

    private static void solveNQueenProblem(int col, char[][] board, boolean[] leftRow, boolean[] lowerDiagonal, boolean[] upperDiagonal, List<List<String>> res) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (!leftRow[row] && !lowerDiagonal[row + col] && !upperDiagonal[board.length - 1 + col - row]) {
                board[row][col] = 'Q';
                leftRow[row] = true;
                lowerDiagonal[row + col] = true;
                upperDiagonal[board.length - 1 + col - row] = true;
                solveNQueenProblem(col + 1, board, leftRow, lowerDiagonal, upperDiagonal, res);
                board[row][col] = '.';
                leftRow[row] = false;
                lowerDiagonal[row + col] = false;
                upperDiagonal[board.length - 1 + col - row] = false;
            }
        }
    }

    private static List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] chars : board) {
            String s = new String(chars);
            res.add(s);
        }
        return res;
    }
}
