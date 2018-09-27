package com.vitoz.campus.shangtang;


import java.util.*;

/**
 * @Auther: vitoz
 * @Date: 2018/9/26 18:39
 * @Description:
 */
public class Demo3 {
    static HashSet<Point> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i=0;i<n;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        for (int i=0;i<n;i++){
            swapItem(arr, 0, i);
            for (int j=1;j<n;j++){
                swapItem(arr, 1,j);
                for (int k=2;k<n;k++){
                    swapItem(arr, 2, k);
                    TellSquare(arr);
                    swapItem(arr, 2, k);
                }
                swapItem(arr, 1,j);
            }
            swapItem(arr, 0, i);
        }
        System.out.println(set.size()+n);
        for (Point p: set){
            System.out.println(p.x+" "+p.y);
        }
    }

    private static void swapItem(int[][] arr, int i, int j){
        int[] tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = arr[i];
    }

    private static void TellSquare(int[][] arr){
        HashMap<Integer, Integer> mapX = new HashMap<>(4);
        HashMap<Integer, Integer> mapY = new HashMap<>(4);
        Integer x = 0, y = 0;
        for (int i=0;i<3;i++){
            x = mapX.get(arr[i][0]);
            y = mapY.get(arr[i][1]);
            if (x == null){
                mapX.put(arr[i][0], 1);
            }else {
                mapX.put(arr[i][0], x+1);
            }
            if (y == null){
                mapY.put(arr[i][1], 1);
            }else {
                mapY.put(arr[i][1], y+1);
            }
        }
        boolean flag = false;
        for(Map.Entry<Integer, Integer> entryX: mapX.entrySet())
        {
            if (entryX.getValue() == 1){
                x = entryX.getKey();
            }else if (entryX.getValue() == 2){
                flag = true;
            }
        }
        if (!flag){
            return ;
        }
        flag = false;
        for(Map.Entry<Integer, Integer> entryY: mapY.entrySet())
        {
            if (entryY.getValue() == 1){
                y = entryY.getKey();
            }else if (entryY.getValue() == 2){
                flag = true;
            }
        }
        if (!flag){
            return ;
        }
        for (int i=3;i<arr.length;i++){
            if (arr[i][0] == x && arr[i][1] == y){
                return ;
            }
        }
        set.add(new Point(x, y));
        return ;
    }
}
class Point{
    public int x;
    public int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return x*9+y;
    }

    @Override
    public boolean equals(Object obj) {
        Point p = (Point) obj;
        return this.x == p.x && this.y == p.y;
    }
}
