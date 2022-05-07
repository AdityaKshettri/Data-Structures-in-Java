package com.aditya.project.recursion.permutation;

public class SudokuSolver {

    public static void main(String[] args) {
        char[][] sudoku = {
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };
        System.out.println("Given Sudoku :");
        print(sudoku);
        System.out.println("Solved Sudoku :");
        solve(sudoku);
        print(sudoku);
    }

    private static boolean solve(char[][] a) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (a[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(a, i, j, c)) {
                            a[i][j] = c;
                            if (solve(a)) {
                                return true;
                            } else {
                                a[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] a, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (a[i][col] == c) {
                return false;
            }
            if (a[row][i] == c) {
                return false;
            }
            if (a[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }

    private static void print(char[][] a) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
