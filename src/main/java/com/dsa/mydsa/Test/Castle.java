package com.dsa.mydsa.Test;

/**
 * Created by zhangzhibo on 17-8-12.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Castle {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();//城堡个数
        ArrayList<Point> aList = new ArrayList<Point>();
        //将城堡存入ArrayList中
        for (int i = 0; i < num; i++) {
            double x = Double.parseDouble(sc.next());
            double y = Double.parseDouble(sc.next());
            Point point = new Point(x, y);
            aList.add(point);
        }
//		for(Point point:aList)
//			System.out.println(point);
        System.out.println(getMax(aList));
//		for(Point point:aList)
//			System.out.println(point);
        sc.close();//关闭流
    }

    public static int getMax(ArrayList<Point> Points) {
        int result = 0;
        int size = Points.size();
        if (size < 4)//小于四座城堡，则都是凸焦点
            return 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {//以i,j两城堡为射线，遍历剩下的城堡
                if (i == j) continue;//重复的跳过
                int n1 = 0;//射线一侧的城堡
                int n2 = 0;//射线另一侧的城堡
                int n = 2;//至少有i,j两个城堡
                double theta1 = 0;//射线一侧最大夹角
                double theta2 = 0;//射线另一侧最大夹角
                for (int k = 0; k < size; k++) {
                    if (k == i || k == j) continue;//重复的跳过
                    Point tmp = help(Points.get(i), Points.get(j), Points.get(k));
                    if (tmp.y == 0) //位于射线上
                        n++;
                    else {
                        if (tmp.x > 0) {//射线一侧
                            n1++;
                            theta1 = Math.max(theta1, tmp.y);
                        } else if (tmp.x < 0) {//射线另一侧
                            n2++;
                            theta2 = Math.max(theta2, tmp.y);
                        }
                    }
                }
                if (Math.acos(-1) < theta1 + theta2) {//判断是否凸焦点
                    n1 = n + Math.max(n1, n2);
                    result = Math.max(n1, result);
                }
            }
        }
        return result;
    }

    public static Point help(Point point1, Point point2, Point point3) {//计算三个点的夹角和第三个点在射线的两侧
        Point result = new Point();
        Point p1 = new Point(point1.x, point1.y);
        Point p2 = new Point(point2.x, point2.y);
        Point p3 = new Point(point3.x, point3.y);
        //向量1
        p2.x -= p1.x;
        p2.y -= p1.y;
        //向量2
        p3.x -= p1.x;
        p3.y -= p1.y;

        result.x = p2.x * p3.y - p3.x * p2.y;
        //正负值判断在射线的两端
        result.y = Math.acos((p2.x * p3.x + p2.y * p3.y) /
                Math.sqrt((p2.x * p2.x + p2.y * p2.y) * (p3.x * p3.x + p3.y * p3.y)));
        //向量法计算夹角（0——π）弧度制

        return result;
    }
}

class Point {
    double x = 0;
    double y = 0;

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + this.x + " , " + this.y + ")";
    }
}
