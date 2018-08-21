package com.vitoz.basic.alitest;

import java.util.Scanner;

class Point{
    int x,y ;
    boolean visited;
    public Point(int x,int y){
        this.x=x;
        this.y=y;
        this.visited=false;
    }
    public int getLength(Point point){
        return Math.abs(this.x-point.x)+Math.abs(this.y-point.y);
    }
}

public class MiniDistance {
    public static final Point START=new Point(0,0);
    public static int minPath=Integer.MAX_VALUE;

    public static void main(String[] args){
        int sum=0,count=0;
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        Point[] points=new Point[num];
        for(int i=0;i<num;i++){
            String str[]=sc.nextLine().trim().split(",");
            points[i]=new Point(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
        }
        System.out.print(caculate(START,points,sum,count));
    }

    public static int caculate(Point start, Point[] points, int sum, int count){
        if(count==points.length){
            minPath=Math.min(minPath,sum+start.getLength(START));
            return minPath;
        }

        for(int i=0;i<points.length;i++){
            if(points[i].visited==false){
                sum+=points[i].getLength(start);
                if(sum<minPath){
                    points[i].visited=true;
                    caculate(points[i],points,sum,count+1);
                }
                sum-=points[i].getLength(start);
                points[i].visited=false;
            }
        }
        return minPath;
    }
}
