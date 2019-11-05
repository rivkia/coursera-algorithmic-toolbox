import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Math.*;

public class Closest {
    static class PairPoint {
        Point a, b;
        double distance;

        public PairPoint(Point a, Point b, boolean equal) {
            this.a = a;
            this.b = b;

            this.distance = equal ? Double.MAX_VALUE : calcDistance();
        }

        private double calcDistance() {
            return Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));
        }
    }

    static class Point implements Comparable<Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
        }
    }

    static double minimalDistance(int[] x, int y[]) {
        // double ans = Double.POSITIVE_INFINITY;
        //write your code here
        //sort by x
        Point[] points = new Point[x.length];
        for (int i = 0; i < x.length; i++) {
            points[i] = new Point(x[i], y[i]);
        }

        Arrays.sort(points, (a, b) -> a.x == b.x ? Long.signum(a.y - b.y) : Long.signum(a.y - b.y));

        PairPoint minPointsDistance = getMinPointsDistance(points, 0, x.length);
        return minPointsDistance == null ? -1 : minPointsDistance.distance;
    }

    private static PairPoint getMinPointsDistance(Point[] points, int left, int right) {
        PairPoint minPointsDistance;
        if (left + 1 > right) {
            return null;
        }
        if (left + 2 >= right) {
//            for (int i = left; i < right; i++) {
//                for (int j = i + 1; i < right; j++) {
            return new PairPoint(points[left], points[right - 1], left == right - 1);
//                }
//            }
        }


        int ave = (left + right) / 2;
        PairPoint minLeftDistance = getMinPointsDistance(points, left, ave);
        PairPoint minRightDistance = getMinPointsDistance(points, ave, right);
        minPointsDistance = minLeftDistance.distance > minRightDistance.distance ? minRightDistance : minLeftDistance;

        // loop n times
        int midLeft = ave;
        int midRight = ave;
        while (midLeft > left && Math.abs(points[midLeft].x - points[ave].x) <= minPointsDistance.distance) midLeft--;
        while (midRight < right && Math.abs(points[midRight].x - points[ave].x) < minPointsDistance.distance) midRight++;
        if (midLeft + 1 == midRight || midLeft == left && midRight == right)
            return minPointsDistance;
        PairPoint minPair = getMinPointsDistance(points, midLeft, midRight);
        if (minPair.distance < minPointsDistance.distance) minPointsDistance = minPair;
        return minPointsDistance;
    }


    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }
        System.out.println(minimalDistance(x, y));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
