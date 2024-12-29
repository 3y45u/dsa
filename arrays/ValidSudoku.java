package arrays;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && set.contains(board[i][j])) {
                    return false;
                } else {
                    set.add(board[i][j]);
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.' && set.contains(board[j][i])) {
                    return false;
                } else {
                    set.add(board[j][i]);
                }
            }

        }

        int[] indexes = {0, 3, 6};

        for (int row : indexes) {
            for (int col : indexes) {
                if (!validateBox(row, col, board)) {
                    return false;
                }
            }
        }

        return true;

    }

    public boolean validateBox(int row, int col, char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int i = row; i < row + 3 && i < 9; i++) {
            for (int j = col; j < col + 3 && j < 9; j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) {
                        return false;
                    } else {
                        set.add(board[i][j]);
                    }
                }

            }
        }

        return true;
    }
}
