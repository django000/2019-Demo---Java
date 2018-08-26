package com.vitoz.offer;

public class Demo4 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(findElement(arr, 7));
    }

    public static boolean findElement(int[][] arr, int element){
        boolean flag = false;
        int rows, cols;
        if (arr != null && (rows=arr.length)>0 && (cols=arr[0].length)>0){
            int row=0,col=cols-1;
            while (row<rows && col>=0){
                if (arr[row][col] == element){
                    flag = true;
                    break;
                }else if (arr[row][col] > element){
                    col--;
                }else{
                    row++;
                }
            }
        }
        return flag;
    }
}
