package com.dsa.mydsa.NowCoder.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by zhangzhibo on 17-8-12.
 */
public class MyCastle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc = new Scanner(System.in);
        ArrayList<Point> points = new ArrayList<>(size);
        Map<Integer, Point> map = new HashMap<>();
        int[] index = new int[size];
        for (int i = 0; i < size; i++) {
            double x = Double.parseDouble(sc.next());
            double y = Double.parseDouble(sc.next());
            Point point = new Point(x, y);
            index[i] = i;
            points.add(point);
            map.put(i, point);
        }
//        for (int i = 0; i < size; i++) {
//            System.out.println(points.get(i));
//        }
        System.out.println(castle(points));
    }

    public static Point castHelp(Point p1, Point p2, Point p3) {
        Point point1 = new Point(p1.x, p1.y);
        Point point2 = new Point(p2.x, p2.y);
        Point point3 = new Point(p3.x, p3.y);
        Point result;
        point2.x = point2.x - point1.x;
        point2.y = point2.y - point1.y;
        point3.x = point3.x - point1.x;
        point3.y = point3.x - point1.y;
        double x = point2.x * point3.x - point3.x * point2.y;
        double tmp1 = Math.acos(point2.x * point3.x + point2.y * point3.y);
        double tmp2 = Math.sqrt(Math.pow(point2.x, 2) + Math.pow(point2.y, 2)) * (Math.pow(point3.x, 2) + Math.pow(point2.y, 2));
        double y = tmp1 / tmp2;
        result = new Point(x, y);
        return result;
    }

    public static int castle(int[] index, Map<Integer, Point> map) {
        int result = 0;
        int size = map.size();
        return 0;
    }

    public static int castle(ArrayList<Point> points) {
        int result = 0;
        int vl = points.size();
        for (int i = 0; i < vl; i++) {
            for (int j = 0; j < vl; j++) {
                if (i == j) {
                    continue;
                }
                int count0 = 2;
                int count1 = 0;
                int count2 = 0;
                double angle1 = 0;
                double angle2 = 0;
                for (int k = 0; k < vl; k++) {
                    if (k == j || i == k) {
                        continue;
                    }
                    Point p = castHelp(points.get(i), points.get(j), points.get(k));
                    if (p.y < 1e-9) {
                        count0++;
                    } else {
                        if (p.x > 0) {
                            count1++;
                            angle1 = Math.max(angle1, p.y);
                        } else if (0 > p.x) {
                            count2++;
                            angle2 = Math.max(angle2, p.y);
                        }
                    }
                }
                if (Math.acos(-1) < angle1 + angle2) {
                    count1 = count1 < count2 ? (count2 + count0) : (count1 + count0);
                    result = Math.max(result, count1);
                }
            }
        }
        return result;
    }

    public static ArrayList<String> reslt = new ArrayList<>();

    public static void combine(int i, String str, int[] num, int n) {
        if (n == 0) {
//            System.out.println(str);
            reslt.add(str);
            return;
        }
        if (i == num.length) {
            return;
        }
        combine(i + 1, str + num[i] + ",", num, n - 1);
        combine(i + 1, str, num, n);
    }
}
