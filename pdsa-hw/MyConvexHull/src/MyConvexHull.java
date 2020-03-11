
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author don
 */
public class MyConvexHull {

    public static int[] ConvexHullVertex(Point2D[] a) {
        int countsize = 0;
        ArrayList al = new ArrayList();
        int[] movetoorder = new int[a.length];
        //find lowest point
        double hold = a[0].y();
        int element = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i].y() < hold) {
                hold = a[i].y();
                element = i;
            }
        }
        //end find lowest point
        //find degree between lowest and ith point
        double[] olddegree = new double[a.length];
        double[] newdegree = new double[a.length];

        for (int i = 0; i < a.length; i++) {
            if (a[i].y() != hold && a[i].y() != 1) {
                StdDraw.filledCircle(a[i].x(), a[i].y(), 0.01);
//                StdDraw.setPenColor(StdDraw.GREEN);
//                StdDraw.line(a[element].x(), a[element].y(), a[i].x(), a[i].y());
//                StdDraw.setPenColor();
                if (Math.toDegrees(Math.atan((a[i].y() - a[element].y()) / (a[i].x() - a[element].x()))) < 0) {
                    olddegree[i] = 180 + Math.toDegrees(Math.atan((a[i].y() - a[element].y()) / (a[i].x() - a[element].x())));
//                    StdOut.println("point " + i + " olddegree = " + olddegree[i]);
                    newdegree[i] = olddegree[i];
                } else {
                    olddegree[i] = Math.toDegrees(Math.atan((a[i].y() - a[element].y()) / (a[i].x() - a[element].x())));
//                    StdOut.println("point " + i + " olddegree = " + olddegree[i]);
                    newdegree[i] = olddegree[i];
                }
            } else if (a[i].y() != 1) {
//                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.filledCircle(a[i].x(), a[i].y(), 0.01);
                StdDraw.setPenColor();
            }
        }
        //end find degree between lowest and ith point
//        Arrays.sort(newdegree);
//        double[] xx = new double[a.length];
//        double[] yy = new double[a.length];
        //put text follow the order of degree
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a.length; j++) {
//                if (olddegree[i] == newdegree[j] && olddegree[i] != 0) {
//                    StdDraw.text(a[i].x(), a[i].y() + 0.03, String.valueOf(i));
////                    xx[i] = a[j].x();
////                    yy[i] = a[j].y();
//                    movetoorder[i] = j;
//                    break;
//                }
//            }
//        }
        for (int i = 0; i < a.length; i++) {
//            StdDraw.text(a[i].x(), a[i].y() + 0.03, String.valueOf(i));
        }
        //end put text follow the order of degree
        //find degree of lowest and largest point
        double lowestdegree = olddegree[1];
        int pointoflowestdegree = 0;
        int pointoflargestdegree = 0;
        for (int i = 0; i < a.length; i++) {
            if (olddegree[i] != 0) {
                lowestdegree = olddegree[i];
                pointoflowestdegree = i;
                break;
            }

        }
        double largestdegree = lowestdegree;
        for (int i = 1; i < a.length; i++) {
            if (lowestdegree >= olddegree[i] && olddegree[i] != 0) {
                lowestdegree = olddegree[i];
                pointoflowestdegree = i;
            }
            if (largestdegree <= olddegree[i]) {
                largestdegree = olddegree[i];
                pointoflargestdegree = i;
            }
        }
        //end find degree of lowest and largest point
        //convers hull
        int endpoint = pointoflowestdegree;
        int starpoint = element;
        double degreeshift = Math.toDegrees(Math.atan((a[endpoint].y() - a[starpoint].y()) / (a[endpoint].x() - a[starpoint].x())));
        StdDraw.setPenRadius(0.005);
        StdDraw.line(a[starpoint].x(), a[starpoint].y(), a[endpoint].x(), a[endpoint].y());
        starpoint = endpoint;
//        StdOut.print(element + " ");
        al.add(element);
        while (endpoint != pointoflargestdegree) {
//            StdOut.print(starpoint + " ");
            double[] testdegree = new double[a.length];
            double[] deltax = new double[a.length];
            double[] deltay = new double[a.length];
            for (int i = 0; i < a.length; i++) {
                if (a[i].y() != 1) {
                    deltax[i] = a[i].x() - a[starpoint].x();
                    deltay[i] = a[i].y() - a[starpoint].y();
                }
            }
            for (int i = 0; i < a.length; i++) {
                if (!al.contains(i)) {
                    if (deltax[i] == 0) {
                        testdegree[i] = 0;
                    } else if (Math.toDegrees(Math.atan(deltay[i] / deltax[i])) - degreeshift < 0) {
                        testdegree[i] = 180 + Math.toDegrees(Math.atan(deltay[i] / deltax[i])) - degreeshift;
//                        StdOut.println("new point " + i + " compare to " + starpoint + " degree = " + testdegree[i]);
//                    StdOut.println("only point degree = " + (180 + Math.toDegrees(Math.atan(deltay[i] / deltax[i]))));

                    } else {
                        testdegree[i] = Math.toDegrees(Math.atan(deltay[i] / deltax[i])) - degreeshift;
//                        StdOut.println("new point " + i + "compare to " + starpoint + " degree = " + testdegree[i]);
//                    StdOut.println("only point degree = " + (Math.toDegrees(Math.atan(deltay[i] / deltax[i]))));

                    }
                }
            }
            //find minimum degree
            hold = 0;
            int holdtp = endpoint;
            for (int i = 0; i < a.length; i++) {
                if (testdegree[i] > 0.0001) {
                    hold = testdegree[i];
                    holdtp = i;
                    break;
                }
            }
            //find next endpoint
            for (int i = 0; i < a.length; i++) {
                if (hold == 0) {
//                    StdOut.println("hold = 0");
                    for (int j = 0; j < a.length; j++) {
                        if (hold > testdegree[j]) {
                            hold = testdegree[j];
                            holdtp = j;
//                            StdOut.println("hold = " + hold);
                        }
                    }
                    break;
                } else if (hold > testdegree[i] && testdegree[i] > 0.0001) {
                    hold = testdegree[i];
                    holdtp = i;
                }
            }
            //end find next endpoint
            countsize++;
            al.add(endpoint);
            endpoint = holdtp;
            degreeshift += Math.abs(testdegree[endpoint]);
            if (degreeshift > 180) {
                degreeshift -= 180;
            }
//            StdOut.println("degreeshift = " + degreeshift + " end point = " + endpoint);
            StdDraw.setPenRadius(0.005);
            StdDraw.line(a[starpoint].x(), a[starpoint].y(), a[endpoint].x(), a[endpoint].y());
            starpoint = endpoint;
        }
        //end convers hull
        StdDraw.setPenRadius(0.005);
        StdDraw.line(a[element].x(), a[element].y(), a[endpoint].x(), a[endpoint].y());
        al.add(endpoint);
        int[] reint1 = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            reint1[i] = (int) al.get(i);
        }

        return reint1;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        int points = in.readInt();
        Point2D[] a = new Point2D[points];
        Point2D[] b = new Point2D[points];
        for (int i = 0; i < points; i++) {
            a[i] = new Point2D(in.readDouble(), in.readDouble());
        }
        //debug test
        //        //construct n points randomly
        int n = 20;
        double[] x = new double[n];
        double[] y = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = StdRandom.uniform();
            y[i] = StdRandom.uniform();
            a[i] = new Point2D(x[i], y[i]);
        }
//        //end construct n points

        //find lowest point
        double hold = a[0].y();
        int element = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i].y() < hold) {
                hold = a[i].y();
                element = i;
            }
        }
        b[0] = new Point2D(a[element].x(), a[element].y());
        //end find lowest point
        //find degree between lowest and ith point
        double[] olddegree = new double[a.length];
        double[] newdegree = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i].y() != hold) {
//                StdDraw.filledCircle(a[i].x(), a[i].y(), 0.01);
//                StdDraw.setPenColor(StdDraw.GREEN);
//                StdDraw.line(a[element].x(), a[element].y(), a[i].x(), a[i].y());
//                StdDraw.setPenColor();
                if (Math.toDegrees(Math.atan((a[i].y() - a[element].y()) / (a[i].x() - a[element].x()))) < 0) {
                    olddegree[i] = 180 + Math.toDegrees(Math.atan((a[i].y() - a[element].y()) / (a[i].x() - a[element].x())));
//                    StdOut.println("point " + i + " olddegree = " + olddegree[i]);
                    newdegree[i] = olddegree[i];
                } else {
                    olddegree[i] = Math.toDegrees(Math.atan((a[i].y() - a[element].y()) / (a[i].x() - a[element].x())));
//                    StdOut.println("point " + i + " olddegree = " + olddegree[i]);
                    newdegree[i] = olddegree[i];
                }
            } else {
//                StdDraw.setPenColor(StdDraw.RED);
//                StdDraw.filledCircle(a[i].x(), a[i].y(), 0.01);
//                StdDraw.setPenColor();
            }
        }
        //end find degree between lowest and ith point
        Arrays.sort(newdegree);
//        double[] xx = new double[a.length];
//        double[] yy = new double[a.length];
        //put text follow the order of degree
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (olddegree[i] == newdegree[j]) {
//                    xx[i] = a[j].x();
//                    yy[i] = a[j].y();
                    b[j] = new Point2D(a[i].x(), a[i].y());
//                    StdDraw.filledCircle(b[j].x(), b[j].y(), 0.01);
                    StdDraw.text(b[j].x(), b[j].y() + 0.03, String.valueOf(j));
//                    StdDraw.setPenColor(StdDraw.GREEN);
//                    StdDraw.line(b[element].x(), b[element].y(), b[j].x(), b[j].y());
//                    StdDraw.setPenColor();
                    break;

                }
            }
        }
        //source order
        ArrayList order1 = new ArrayList();
        int[] order = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            order[i] = i;
        }
        //end source order
        //call function
        int[] g = ConvexHullVertex(b);
        int countsize = g.length;
        for (int i = 0; i < g.length; i++) {
            StdOut.print(g[i] + " ");
        }
        while (countsize < a.length - 2) {
            Point2D[] c = new Point2D[a.length - countsize];
            ArrayList findremain = new ArrayList();
            for (int i = 0; i < g.length; i++) {
                order[g[i]] = 0;
            }
            //find remain point
            order1 = new ArrayList();
            for (int i = 0; i < order.length; i++) {
                if (order[i] != 0) {
                    order1.add(order[i]);
                }
            }
            order = new int[order1.size()];
            for (int i = 0; i < order1.size(); i++) {
                order[i] = (int) order1.get(i);
            }
            //end find remain point

            //store remin point to next call
            for (int i = 0; i < c.length; i++) {
                c[i] = new Point2D(b[(int) order1.get(i)].x(), b[(int) order1.get(i)].y());
            }
            StdOut.println();
            g = ConvexHullVertex(c);
            countsize += g.length;
            for (int i = 0; i < g.length; i++) {
                StdOut.print((int) order1.get(g[i]) + " ");
            }
        }

//        //construct n points randomly
//        int n = 10;
//        double[] x = new double[n];
//        double[] y = new double[n];
//        double[] olddegree = new double[n];
//        double[] newdegree = new double[n];
//        for (int i = 0; i < n; i++) {
//            x[i] = StdRandom.uniform();
//            y[i] = StdRandom.uniform();
//        }
//        //end construct n points
//        //find lowest point
//        double hold = y[0];
//        int element = 0;
//        for (int i = 1; i < n; i++) {
//            if (y[i] < hold) {
//                hold = y[i];
//                element = i;
//            }
//        }
////        StdOut.println("lowest point is " + hold + " element is " + element);
//        //end find lowest point
//        //find degree between lowest and ith point
//        for (int i = 0; i < n; i++) {
//            if (y[i] != hold) {
//                StdDraw.filledCircle(x[i], y[i], 0.01);
//                StdDraw.setPenColor(StdDraw.GREEN);
//                StdDraw.line(x[element], y[element], x[i], y[i]);
//                StdDraw.setPenColor();
//                if (Math.toDegrees(Math.atan((y[i] - y[element]) / (x[i] - x[element]))) < 0) {
//                    olddegree[i] = 180 + Math.toDegrees(Math.atan((y[i] - y[element]) / (x[i] - x[element])));
////                    StdOut.println("point " + i + " olddegree = " + olddegree[i]);
//                    newdegree[i] = olddegree[i];
//                } else {
//                    olddegree[i] = Math.toDegrees(Math.atan((y[i] - y[element]) / (x[i] - x[element])));
////                    StdOut.println("point " + i + " olddegree = " + olddegree[i]);
//                    newdegree[i] = olddegree[i];
//                }
//            } else {
//                StdDraw.setPenColor(StdDraw.RED);
//                StdDraw.filledCircle(x[i], y[i], 0.01);
//                StdDraw.setPenColor();
//            }
//        }
//        //end find degree between lowest and ith point
//        Arrays.sort(olddegree);
//        double[] xx = new double[n];
//        double[] yy = new double[n];
//        //put text follow the order of degree
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (olddegree[i] == newdegree[j]) {
//                    StdDraw.text(x[j], y[j] + 0.03, String.valueOf(i));
//                    xx[i] = x[j];
//                    yy[i] = y[j];
//                    break;
//                }
//            }
//        }
//        //end put text follow the order of degree
//        //convers hull
//        double degreeshift = Math.toDegrees(Math.atan((yy[1] - yy[0]) / (xx[1] - xx[0])));
//        int endpoint = 1;
//        int starpoint = 1;
//        StdDraw.setPenRadius(0.005);
//        StdDraw.line(xx[0], yy[0], xx[1], yy[1]);
//        StdOut.print(element + " ");
//        while (endpoint < n - 1) {
//            StdOut.print(starpoint + " ");
//            double[] testdegree = new double[n];
//            double[] deltax = new double[n];
//            double[] deltay = new double[n];
//            for (int i = 0; i < n; i++) {
//                deltax[i] = xx[i] - xx[starpoint];
//                deltay[i] = yy[i] - yy[starpoint];
//            }
//            for (int i = starpoint; i < n; i++) {
//                double uu = Math.toDegrees(Math.atan(deltay[i] / deltax[i]));
//                if (Math.toDegrees(Math.atan(deltay[i] / deltax[i])) < 0) {
//                    uu = Math.toDegrees(Math.atan(deltay[i] / deltax[i])) + 360;
//                }
//                if (Math.toDegrees(Math.atan(deltay[i] / deltax[i])) - degreeshift < 0) {
//                    testdegree[i] = 180 + Math.toDegrees(Math.atan(deltay[i] / deltax[i])) - degreeshift;
////                    StdOut.println("new point " + i + " compare to " + starpoint + " degree = " + testdegree[i]);
////                    StdOut.println("only point degree = " + (180 + Math.toDegrees(Math.atan(deltay[i] / deltax[i]))));
//
//                } else {
//                    testdegree[i] = Math.toDegrees(Math.atan(deltay[i] / deltax[i])) - degreeshift;
////                    StdOut.println("new point " + i + "compare to " + starpoint + " degree = " + testdegree[i]);
////                    StdOut.println("only point degree = " + (Math.toDegrees(Math.atan(deltay[i] / deltax[i]))));
//                }
//            }
//            //find minimum degree
//            hold = 0;
//            int holdtp = endpoint + 1;
//            for (int i = endpoint + 1; i < n; i++) {
//                if (testdegree[i] > 0) {
//                    hold = testdegree[i];
//                    holdtp = i;
//                    break;
//                }
//            }
//            for (int i = endpoint + 1; i < n; i++) {
//                if (hold == 0) {
////                    StdOut.println("hold = 0");
//                    for (int j = endpoint + 1; j < n; j++) {
//                        if (hold > testdegree[j]) {
//                            hold = testdegree[j];
//                            holdtp = j;
////                            StdOut.println("hold = "+hold);
//                        }
//                    }
//                    break;
//                } else if (hold > testdegree[i] && testdegree[i] > 0) {
//                    hold = testdegree[i];
//                    holdtp = i;
//                }
//            }
//            starpoint = endpoint;
//            endpoint = holdtp;
//            degreeshift += testdegree[endpoint];
//            StdDraw.setPenRadius(0.005);
//            StdDraw.line(xx[starpoint], yy[starpoint], xx[endpoint], yy[endpoint]);
//            starpoint = endpoint;
//
//        }
//        //end convers hull
//        StdDraw.setPenRadius(0.005);
//        StdDraw.line(xx[0], yy[0], xx[endpoint], yy[endpoint]);
//        StdOut.println(endpoint);
    }
}
