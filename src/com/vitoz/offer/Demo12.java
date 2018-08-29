package com.vitoz.offer;

public class Demo12 {
    public static void main(String[] args) {
        char[][] arr = {{'a','b','t','g'},{'c','f','c','s'},{'j','d','e','h'}};
        String str = "bfce";
        System.out.println(hasPath(arr, str));
    }

    /**
     *@描述 判断该二维数组中是否包含该字符串路径
     *@参数  [输入二维char数组, 输入匹配路径字符串]
     *@返回值  数组中是否存在该字符串路径
     *@创建人  vitoz
     *@创建时间  2018/8/30
     *@修改人和其它信息
     */
    private static boolean hasPath(char[][] arr, String str){
        if (arr == null || arr.length == 0 || (arr.length == 1 && arr[0].length ==0)){
            return false;
        }
        int rows = arr.length, cols = arr[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                visited[i][j] = false;
            }
        }
        int pathLen = 0;
        for (int row=0;row<rows;row++){
            for (int col=0;col<cols;col++){
                if (hasPathCore(arr, rows, cols, row, col, str, pathLen, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *@描述 判断此节点是否是输入字符串中合理节点
     *@参数  [输入二维数组, 总行, 总列, 当前行, 当前列, 输入字符串, 当前路径长度, 路径访问二维数组]
     *@返回值  boolean
     *@创建人  vitoz
     *@创建时间  2018/8/30
     *@修改人和其它信息
     */
    private static boolean hasPathCore(char[][] arr, int rows, int cols, int row, int col, String str, int pathLen, boolean[][] visited){

        if (str.length() == pathLen){
            return true;
        }
        boolean hasPath = false;
        if (row>=0 && row<rows && col>=0 && col<cols &&
                arr[row][col]==str.charAt(pathLen) && !visited[row][col]){
            pathLen++;
            visited[row][col] = true;

            hasPath = hasPathCore(arr,rows,cols,row,col-1,str,pathLen,visited) ||
                    hasPathCore(arr,rows,cols,row,col+1,str,pathLen,visited) ||
                    hasPathCore(arr,rows,cols,row-1,col,str,pathLen,visited) ||
                    hasPathCore(arr,rows,cols,row+1,col,str,pathLen,visited);

            if (!hasPath){
                pathLen--;
                visited[row][col] = false;
            }
        }
        return hasPath;
    }
}
