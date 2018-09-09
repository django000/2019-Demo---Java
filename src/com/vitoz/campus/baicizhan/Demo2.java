package com.vitoz.campus.baicizhan;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        char[][] arr = new char[m][n];
        for (int i=0;i<m;i++){
            arr[i] = sc.nextLine().trim().toCharArray();
        }
        String str = sc.nextLine().trim();
        System.out.println(hasPath(arr, str));
    }

    private static boolean hasPath(char[][] arr, String str){
        if (arr == null || arr.length == 0 || (arr.length == 1 && arr[0].length ==0)){
            return false;
        }
        int rows = arr.length, cols = arr[0].length;
        for (int row=0;row<rows;row++){
            for (int col=0;col<cols;col++){
                if (hasPathCore(arr, str, 0, row, col)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(char[][] board, String word, int index, int x, int y){

        if(index == word.length()-1 && word.charAt(index)==board[x][y]){
            return true;
        }

        if(word.charAt(index) != board[x][y]){
            return false;
        }

        char tmp = board[x][y];
        board[x][y] = '.';
        boolean b1 = false, b2 = false, b3 = false, b4 = false;
        if(x-1>=0 && board[x-1][y] != '.'){
            b1 = hasPathCore(board, word, index+1, x-1, y);
        }
        if(!b1 && y-1>=0 && board[x][y-1] != '.'){
            b2 = hasPathCore(board, word, index+1, x, y-1);
        }
        if(!b1 && !b2 && x+1<board.length && board[x+1][y] != '.'){
            b3 = hasPathCore(board, word, index+1, x+1, y);
        }
        if(!b1 && !b2 && !b3 && y+1<board[0].length && board[x][y+1] != '.'){
            b4 = hasPathCore(board, word, index+1, x, y+1);
        }
        board[x][y] = tmp;
        return b1 || b2 || b3 || b4;
    }
}
