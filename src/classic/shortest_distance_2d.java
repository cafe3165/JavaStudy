package classic;

import java.util.Arrays;
import java.util.Comparator;

public class shortest_distance_2d {
    static class Point {
        double x;
        double y;

        public Point(final double x, final double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[x=" + x + ", y=" + y + "]";
        }
    }

    static class PointCompartor implements Comparator<Point> {
        @Override
        public int compare(Point o1, Point o2) {
            Double x1 = o1.x;
            Double x2 = o2.x;
            Double y1 = o1.y;
            Double y2 = o2.y;
            if (!x1.equals(x2)) {
                return x1.compareTo(x2);
            }
            return y1.compareTo(y2);
        }
    }

    static double dis(final Point[] point, int i, int j) {
        double xdif = point[i].x - point[j].x;
        double ydif = point[i].y - point[j].y;
        return Math.sqrt(xdif * xdif + ydif * ydif);
    }

    static double solve(final Point[] a) {
        Arrays.sort(a, new PointCompartor());
        final Point[] b = new Point[a.length];
        return solve(a, b, 0, a.length - 1);
    }

    static double solve(final Point[] a, final Point[] b, int l, int r) {
        if (l == r) {
            return Integer.MAX_VALUE;
        }

        if (r - l == 1) {
            return dis(a, l, r);
        }

        int mid = (l + r) >> 1;
        double ans = Math.min(solve(a, b, l, mid), solve(a, b, mid + 1, r));
        int k = 0;
        for (int i = l; i <= r; i++) {
            if (Math.abs(a[i].x - a[mid].x) < ans) {
                b[k++] = a[i];
            }
        }

        Arrays.sort(b, 0, k, new PointCompartor());

        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k; j++) {
                if (b[j].y - b[i].y > ans) {
                    break;
                }
                ans = Math.min(ans, dis(a, i, j));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Point[] ps = new Point[11];
        Point p1 = new Point(0, 0);
        Point p2 = new Point(-2, 0);
        Point p3 = new Point(-3, 1);
        Point p4 = new Point(-3, -1);
        Point p5 = new Point(-4, -1);
        Point p6 = new Point(-0.2, 1.4);
        Point p7 = new Point(0.4, 1.4);
        Point p8 = new Point(1, -1);
        Point p9 = new Point(2, 1);
        Point p10 = new Point(2, 2);
        Point p11 = new Point(3, 0);
        ps[0] = p1;
        ps[1] = p2;
        ps[2] = p3;
        ps[3] = p4;
        ps[4] = p5;
        ps[5] = p6;
        ps[6] = p7;
        ps[7] = p8;
        ps[8] = p9;
        ps[9] = p10;
        ps[10] = p11;


        System.out.println(solve(ps));

    }


}
