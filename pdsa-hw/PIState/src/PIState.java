/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author don
 */
public class PIState {

    private double mean;
    private double stddev;
    private double confidenceLo;
    private double confidenceHi;

    // perform T independent tests each N times
    public PIState(int N, int T) {
        if (T <= 0 || N <= 0) {

            throw new IllegalArgumentException("T<=0||N<=0");
        }

        double[] piValue = new double[T];

        for (int i = 0; i < T; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                double x = StdRandom.uniform(-1d, 1d);
                double y = StdRandom.uniform(-1d, 1d);
                if (x * x + y * y <= 1.0) {
                    count++;

                }
            }
            piValue[i] = (double) count / N * 4d;
        }
        mean = StdStats.mean(piValue);
        stddev = StdStats.stddev(piValue);
        double interval = 1.96 * stddev / Math.sqrt(T);
        confidenceLo = mean - interval;
        confidenceHi = mean + interval;

    }

    // sample mean
    public double mean() {
        return mean;
    }

    // sample standard deviation
    public double stddev() {
        return stddev;
    }

    // returns lower bound of the 95% confidence interval
    public double confidenceLo() {
        return confidenceLo;
    }

    // returns upper bound of the 95% confidence interval
    public double confidenceHi() {
        return confidenceHi;
    }

    // test client
    public static void main(String[] args) {
        int N = 1000;
        int T = 10000*10;
        PIState ps = new PIState(N, T);
        StdOut.println("mean       = " + ps.mean());
        StdOut.println("stddev       = " + ps.stddev());
        StdOut.println("95% confidence interval =  " + ps.confidenceLo()
                + "," + ps.confidenceHi());

    }
}
