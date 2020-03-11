/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chien-yu
 */
public class Percolation {

    private boolean[][] cell;
    private WeightedQuickUnionUF uf;
    private final int n;
    private final int target;

    private int getID(int i, int j) {

        // students
        return n * (i - 1) * (j - 1);
    }

    public Percolation(int N) {              // create N-by-N grid, with all sites blocked
        n = N;
        target = getID(n - 1, n - 1);

        // students: initialize the two-dimentional array
        cell = new boolean[N + 1][];
        for (int i = 0; i <= N; i++) {
            cell[i] = new boolean[N + 1];
            for (int j = 0; j <= N; j++) {
                cell[i][j] = false;
            }
        }

        // students: initialize the union-find object
        uf = new WeightedQuickUnionUF(N*N);

        // set the target cell as open
        cell[n - 1][n - 1] = true;

    }

    public void open(int i, int j) {         // open site (row i, column j) if it is not open already
        cell[i][j] = true;

        // students: connect the cell with its adjacent open cells
    }

    public boolean isOpen(int i, int j) {    // is site (row i, column j) open?
        return cell[i][j];
    }

    public boolean isFull(int i, int j) {    // is site (row i, column j) connected to the target?
        // students: modify the codes
        return false;
    }

    public boolean percolates() {            // does the system percolate?
        return true;
    }

    public static void main(String[] args) {  // test client (optional)

    }
}
