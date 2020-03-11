/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author don
 */
public class Clustering {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        int points = in.readInt();
        int countsize = points;
        Point2D[] point = new Point2D[points];
        ArrayList<Point2D> pointlist = new ArrayList();
        ArrayList<Integer> eachsize = new ArrayList();
        ST<Point2D, Integer> st = new ST<Point2D, Integer>();
        for (int i = 0; i < points; i++) {  //store file as arraylist
            point[i] = new Point2D(in.readDouble(), in.readDouble());
            StdDraw.filledCircle(point[i].x(), point[i].y(), 0.005);
//            StdDraw.text(point[i].x(), point[i].y() + 0.02, String.valueOf(i));
            pointlist.add(point[i]);
            eachsize.add(1);
            st.put(point[i], 1);
        }
        Collections.sort(pointlist);
        while (countsize > 3) {
            //find min distance
            double mind = pointlist.get(0).distanceTo(pointlist.get(1));
            int mindp = 0;
            int mindp1 = 1;
//            for (int i = 0; i < countsize; i++) {
//                for (int j = i + 1; j < countsize; j++) {
//                    if (mind > pointlist.get(i).distanceTo(pointlist.get(j))) {
//                        mind = pointlist.get(i).distanceTo(pointlist.get(j));
//                        mindp = i;
//                        mindp1 = j;
//                    }
//                    if (pointlist.get(j).y() - pointlist.get(i).y() > mind) {
//                        break;
//                    }
//                }
//            }
            int i = 0, j = 0;
            Point2D zxc = new Point2D(0, 0);
            Point2D zxc1 = new Point2D(0, 0);
            for (Point2D key : st.keys()) {
                for (Point2D key1 : st.keys()) {
                    if (mind > key1.distanceTo(key) && key1.distanceTo(key) != 0) {
                        mind = key1.distanceTo(key);
                        mindp = i;
                        mindp1 = j;
                        zxc1 = key1;
                        zxc = key;
                    }
                    j++;
                    if (key1.y() - key.y() > mind) {
                        break;
                    }
                }
                i++;
                j = 0;
            }
            Collections.sort(pointlist);
            StdDraw.setPenColor(Color.GREEN);
//            StdDraw.line(pointlist.get(mindp).x(), pointlist.get(mindp).y(), pointlist.get(mindp1).x(), pointlist.get(mindp1).y());
            StdDraw.line(zxc.x(), zxc.y(), zxc1.x(), zxc1.y());
            //create new point as center of min pair
//            Point2D temp = new Point2D((pointlist.get(mindp).x() * eachsize.get(mindp) + pointlist.get(mindp1).x() * eachsize.get(mindp1)) / (eachsize.get(mindp) + eachsize.get(mindp1)), (pointlist.get(mindp).y() * eachsize.get(mindp) + pointlist.get(mindp1).y() * eachsize.get(mindp1)) / (eachsize.get(mindp) + eachsize.get(mindp1)));
            Point2D temp = new Point2D((pointlist.get(mindp).x() * st.get(pointlist.get(mindp)) + pointlist.get(mindp1).x() * st.get(pointlist.get(mindp1))) / (st.get(pointlist.get(mindp)) + st.get(pointlist.get(mindp1))), (pointlist.get(mindp).y() * st.get(pointlist.get(mindp)) + pointlist.get(mindp1).y() * st.get(pointlist.get(mindp1))) / (st.get(pointlist.get(mindp)) + st.get(pointlist.get(mindp1))));
//            pointlist.add(temp);

            st.put(temp, st.get(pointlist.get(mindp)) + st.get(pointlist.get(mindp1)));
            st.delete(pointlist.get(mindp));
            pointlist.set(mindp, temp);
//            eachsize.add(eachsize.get(mindp) + eachsize.get(mindp1));
            //delete min pair
//            pointlist.remove(mindp);
//            eachsize.remove(mindp);
            pointlist.remove(mindp1);
            st.delete(pointlist.get(mindp1));

//            Collections.sort(pointlist);
//            for (int i = 0; i < countsize; i++) {
//                if (pointlist.get(i).equals(temp)) {
//                    eachsize.set(i, eachsize.get(mindp) + eachsize.get(mindp1));
//                    eachsize.remove(mindp1);
//                }
//            }
//            eachsize.remove(mindp1 - 1);
            //draw center of min pair
            StdDraw.setPenColor(Color.RED);
            StdDraw.filledCircle(temp.x(), temp.y(), 0.005 * eachsize.get(eachsize.size() - 1));

            countsize--;
        }
        int[] order = new int[3];
        int[] order1 = new int[3];
        for (int i = 0; i < countsize; i++) {
            order[i] = eachsize.get(i);
            order1[i] = eachsize.get(i);
        }
        Arrays.sort(order);
        if (countsize == 3) {
            for (int i = countsize - 1; i >= 0; i--) {
                for (int j = countsize - 1; j >= 0; j--) {
                    if (order1[j] == order[i]) {
                        StdOut.println(eachsize.get(j) + " " + String.format("%.2f", pointlist.get(j).x()) + " " + String.format("%.2f", pointlist.get(j).y()));
                    }
                }
            }
        } else {
            for (int i = 0; i < countsize; i++) {
                StdOut.println(eachsize.get(i) + " " + String.format("%.2f", pointlist.get(i).x()) + " " + String.format("%.2f", pointlist.get(i).y()));
            }
        }
    }

}
