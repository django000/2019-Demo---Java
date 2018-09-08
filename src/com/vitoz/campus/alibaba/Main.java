package com.vitoz.campus.alibaba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String[] pointStr = sc.nextLine().trim().split(",");
//        String[] pointsStr = sc.nextLine().trim().split(",");
//        Point2D point = new Point2D(pointStr[0], pointStr[1]);
//        int len = pointsStr.length / 2;
//        List<Point2D> points = new ArrayList<>(len);
//        for (int i=0;i<len;i++){
//            points.add(new Point2D(pointsStr[2*i], pointsStr[2*i+1]));
//        }
        Point2D point = new Point2D(-2,-2);
        List<Point2D> points = new ArrayList<Point2D>();
        points.add(new Point2D(0,0));
        points.add(new Point2D(0,2));
        points.add(new Point2D(2,2));
        points.add(new Point2D(2,0));
        if (isPtInPoly(point, points)){
            System.out.println("yes,0");
        }else{
            System.out.println("no,"+(int)Math.round(getMinDis(point, points)));
        }
    }

    private static boolean isPtInPoly(Point2D point, List<Point2D> points){
        int N = points.size();
        boolean boundOrVertex = true;
        int intersectCount = 0;
        double precision = 2e-10;
        Point2D p1, p2;
        Point2D p = point;

        p1 = points.get(0);
        for(int i = 1; i <= N; ++i){
            if(p.equals(p1)){
                return boundOrVertex;
            }
            p2 = points.get(i % N);
            if(p.x < Math.min(p1.x, p2.x) || p.x > Math.max(p1.x, p2.x)){
                p1 = p2;
                continue;
            }
            if(p.x > Math.min(p1.x, p2.x) && p.x < Math.max(p1.x, p2.x)){
                if(p.y <= Math.max(p1.y, p2.y)){
                    if(p1.x == p2.x && p.y >= Math.min(p1.y, p2.y)){
                        return boundOrVertex;
                    }

                    if(p1.y == p2.y){
                        if(p1.y == p.y){
                            return boundOrVertex;
                        }else{
                            ++intersectCount;
                        }
                    }else{
                        double xinters = (p.x - p1.x) * (p2.y - p1.y) / (p2.x - p1.x) + p1.y;
                        if(Math.abs(p.y - xinters) < precision){
                            return boundOrVertex;
                        }
                        if(p.y < xinters){
                            ++intersectCount;
                        }
                    }
                }
            }else{
                if(p.x == p2.x && p.y <= p2.y){
                    Point2D p3 = points.get((i+1) % N);
                    if(p.x >= Math.min(p1.x, p3.x) && p.x <= Math.max(p1.x, p3.x)){
                        ++intersectCount;
                    }else{
                        intersectCount += 2;
                    }
                }
            }
            p1 = p2;
        }

        if(intersectCount % 2 == 0){
            //偶数在多边形外
            return false;
        } else {
            //奇数在多边形内
            return true;
        }
    }

    private static double getMinDis(Point2D point, List<Point2D> points){
        int len = points.size();
        double tmpLine;
        int min1=0, min2=1;
        double min1Line = lineSpace(point, points.get(0));
        double min2Line = lineSpace(point, points.get(1));
        if (min1Line > min2Line){
            min1 =1;
            min2 = 0;
            tmpLine = min1Line;
            min1Line = min2Line;
            min2Line = tmpLine;
        }
        for (int i=2;i<len;i++){
            tmpLine = lineSpace(point, points.get(i));
            if (tmpLine < min1Line){
                min2Line = min1Line;
                min1Line = tmpLine;
                min2 = min1;
                min1 = i;
            }else if (tmpLine < min2Line){
                min2Line = tmpLine;
                min2 = i;
            }
        }
        double space = 0;
        double a = lineSpace(points.get(min1), points.get(min2));
        double b = min1Line;
        double c = min2Line;
        if (c <= 0.000001 || b <= 0.000001) {
            space = 0;
            return space;
        }
        if (a <= 0.000001) {
            space = b;
            return space;
        }
        if (c * c >= a * a + b * b) {
            space = b;
            return space;
        }
        if (b * b >= a * a + c * c) {
            space = c;
            return space;
        }
        double p = (a + b + c) / 2;// 半周长
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));// 海伦公式求面积
        space = 2 * s / a;// 返回点到线的距离（利用三角形面积公式求高）
        return space;
    }

    private static double lineSpace(Point2D p1, Point2D p2){
        double len = 0;
        len = Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
        return len;
    }

}

class Point2D {
    public int x;
    public int y;
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point2D(String x, String y){
        this.x = Integer.parseInt(x);
        this.y = Integer.parseInt(y);
    }
}
