
import java.util.Arrays;
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author don
 */
public class FindNeighbors {

    public class Node {

        private Integer key;
        private Integer value;
        private Node left;
        private Node right;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Node getLeft() {
            return this.left;
        }

        public Node getRight() {
            return this.right;
        }

        public Integer getKey() {
            return this.key;
        }

        public Integer getValue() {
            return this.value;
        }

        public void setLeft(Node node) {
            this.left = node;
        }

        public void setRight(Node node) {
            this.right = node;
        }

    }

    private static Node root = null;
    private static int divide = 0;
    private static int count = 1;
    private static int currentsize = 1;
    private static Node[] k = null;
    private static Point2D[] p = null;

    public void init(Point2D[] points) {
        //contruct a 2-d tree
        int j = 1;
        if (k == null) {
            k = new Node[points.length];
            for (int i = 0; i < points.length; i++) {
                k[i] = new Node(count - 1 + i, count - 1 + i);
            }
        }
        if (p == null) {
            p = new Point2D[points.length];
            for (int i = 0; i < points.length; i++) {
                p[i] = points[i];
            }
        }
        Node temp = k[count - 1];
        if (root == null) {
            root = temp;
        }
        while (divide == 0) {
            if (currentsize == k.length) {
                divide = 0;
                return;
            }
            if (points[j].x() > points[0].x()) {
                if (k[count - 1].getRight() == null) {
                    temp.setRight(k[j + count - 1]);
                    j++;
                    currentsize++;
                } else {
                    points = Arrays.copyOfRange(points, j - 1, points.length);
                    if (k[count - 1].getLeft() != null) {
                        count++;
                    }
                    count++;
                    divide = 1;
                    init(points);
                }
            } else if (k[count - 1].getLeft() == null) {
                temp.setLeft(k[j + count - 1]);
                j++;
                currentsize++;
            } else {
                points = Arrays.copyOfRange(points, j - 1, points.length);
                if (k[count - 1].getRight() != null) {
                    count++;
                }
                count++;
                divide = 1;
                init(points);
            }
        }
        while (divide == 1) {
            if (currentsize == k.length) {
                divide = 0;
                return;
            }
            if (points[j].y() > points[0].y()) {
                if (k[count - 1].getRight() == null) {
                    temp.setRight(k[j + count - 1]);
                    j++;
                    currentsize++;
                } else {
                    points = Arrays.copyOfRange(points, j - 1, points.length);
                    if (k[count - 1].getLeft() != null) {
                        count++;
                    }
                    count++;
                    divide = 0;
                    init(points);
                }
            } else if (k[count - 1].getLeft() == null) {
                temp.setLeft(k[j + count - 1]);
                j++;
                currentsize++;
            } else {
                points = Arrays.copyOfRange(points, j - 1, points.length);
                if (k[count - 1].getRight() != null) {
                    count++;
                }
                count++;
                divide = 0;
                init(points);
            }
        }
    }

    public static Point2D[] query(Point2D point, int k) {
        Point2D[] result = new Point2D[k];
//        Point2D[] test = new Point2D[1];
//        int i = 0;
//        double[] comp = new double[p.length];
        Node temp = root;
        ST<Double, Integer> st = new ST<Double, Integer>();
//        while (true) {
//            if (divide == 0) {
//                if (point.x() > p[0].x()) {
//                    if (point.distanceTo(p[temp.getKey()]) > Math.abs(point.x() - p[temp.getKey()].x()) && temp.getLeft() != null) {
//                        
//                        test = query(point ,1);
//                    } else if (temp.getLeft() != null) {
//                        temp = temp.getRight();
//                        divide = 1;
//                    } else {
//                        st.put(point.distanceTo(p[temp.getKey()]), temp.getKey());
//                        i++;
//                    }
//                }
//            }
//            if (divide == 1) {
//                if (point.y() > p[0].y()) {
//                    if (point.distanceTo(p[temp.getKey()]) > Math.abs(point.y() - p[temp.getKey()].y()) && temp.getLeft() != null) {
//
//                    } else if (temp.getLeft() != null) {
//                        temp = temp.getRight();
//                        divide = 0;
//                    } else {
//                        result[i] = p[temp.getKey()];
//                        i++;
//                    }
//                    root = root.getRight();
//                    divide = 0;
//                }
//            }
//        }
        for (int i = 0; i < p.length; i++) {
            st.put(point.distanceTo(p[i]), i);
        }
        int i = 0;
        for (double key : st.keys()) {
            result[i] = p[st.get(key)];
            i++;
            if (i == k) {
                return result;
            }
        }
        return result;
// the points should be sorted accordingly to their distances to the query, from small to large

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //construct n points randomly

//        int n = 5;
//        Point2D[] a = new Point2D[n];
//        double[] x = new double[n];
//        double[] y = new double[n];
//        for (int i = 0; i < n; i++) {
//            x[i] = StdRandom.uniform();
//            y[i] = StdRandom.uniform();
//            a[i] = new Point2D(x[i], y[i]);
//            StdDraw.filledCircle(a[i].x(), a[i].y(), 0.003);
//            StdDraw.text(a[i].x(), a[i].y() + 0.03, String.valueOf(i));
//            
//        }
//        a[0] = new Point2D(0.2, 0.8);
//        a[1] = new Point2D(0.4, 0.6);
//        a[2] = new Point2D(0.6, 0.8);
//        a[3] = new Point2D(0.3, 0.4);
//        a[4] = new Point2D(0.8, 0.5);
//        for (int i = 0; i < a.length; i++) {
//            StdDraw.filledCircle(a[i].x(), a[i].y(), 0.003);
//            StdDraw.text(a[i].x(), a[i].y() + 0.03, String.valueOf(i));
//        }
//        init(a);
//        Point2D g = new Point2D(0.4,0.6);
//        query(g,3);
    }

}
