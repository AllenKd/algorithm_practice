/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author don
 */
public class LanguageAreas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        int row = in.readInt();
        int col = in.readInt();
        ST<String, Integer> st = new ST<String, Integer>();
        char[][] matrix;
        int[][] hold;
        matrix = new char[row][col];
        hold = new int[row][col];
        for (int i = 0; i < row; i++) {
            String test = in.readString();
            for (int j = 0; j < col; j++) {
                matrix[i][j] = test.charAt(j);
                hold[i][j] = col * (i) + j;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (j < col - 1) {
                    if (matrix[i][j] == matrix[i][j + 1]) {
                        hold[i][j + 1] = hold[i][j];
                    }
                }
                if (j > 0) {
                    if (matrix[i][j] == matrix[i][j - 1]) {
                        hold[i][j - 1] = hold[i][j];
                    }
                }
                if (i < row - 1) {
                    if (matrix[i][j] == matrix[i + 1][j]) {
                        hold[i + 1][j] = hold[i][j];
                    }
                }
                if (i > 0) {
                    if (matrix[i][j] == matrix[i - 1][j]) {
                        hold[i - 1][j] = hold[i][j];
                    }
                }
            }
        }
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++) {

                if (j < col - 1) {
                    if (matrix[i][j] == matrix[i][j + 1]) {
                        hold[i][j + 1] = hold[i][j];
                    }
                }
                if (j > 0) {
                    if (matrix[i][j] == matrix[i][j - 1]) {
                        hold[i][j - 1] = hold[i][j];
                    }
                }
                if (i < row - 1) {
                    if (matrix[i][j] == matrix[i + 1][j]) {
                        hold[i + 1][j] = hold[i][j];
                    }
                }
                if (i > 0) {
                    if (matrix[i][j] == matrix[i - 1][j]) {
                        hold[i - 1][j] = hold[i][j];
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = col - 1; j > 0; j--) {

                if (j < col - 1) {
                    if (matrix[i][j] == matrix[i][j + 1]) {
                        hold[i][j + 1] = hold[i][j];
                    }
                }
                if (j > 0) {
                    if (matrix[i][j] == matrix[i][j - 1]) {
                        hold[i][j - 1] = hold[i][j];
                    }
                }
                if (i < row - 1) {
                    if (matrix[i][j] == matrix[i + 1][j]) {
                        hold[i + 1][j] = hold[i][j];
                    }
                }
                if (i > 0) {
                    if (matrix[i][j] == matrix[i - 1][j]) {
                        hold[i - 1][j] = hold[i][j];
                    }
                }
            }
        }

        for (int j = 0; j < col; j++) {
            for (int i = row - 1; i > 0; i--) {

                if (j < col - 1) {
                    if (matrix[i][j] == matrix[i][j + 1]) {
                        hold[i][j + 1] = hold[i][j];
                    }
                }
                if (j > 0) {
                    if (matrix[i][j] == matrix[i][j - 1]) {
                        hold[i][j - 1] = hold[i][j];
                    }
                }
                if (i < row - 1) {
                    if (matrix[i][j] == matrix[i + 1][j]) {
                        hold[i + 1][j] = hold[i][j];
                    }
                }
                if (i > 0) {
                    if (matrix[i][j] == matrix[i - 1][j]) {
                        hold[i - 1][j] = hold[i][j];
                    }
                }
            }
        }
        for (int p = 0; p < row; p++) {
            for (int y = 0; y < col; y++) {
                String key = String.valueOf(matrix[p][y]);

                if (!st.contains(key) && hold[p][y] == col * p + y) {
                    st.put(key, 1);
                } else if (hold[p][y] == col * p + y) {

                    st.put(key, st.get(key) + 1);
                }
            }

        }
        for (String word : st.keys()) {
            StdOut.println(word + ":" + st.get(word));
        }

    }
}
