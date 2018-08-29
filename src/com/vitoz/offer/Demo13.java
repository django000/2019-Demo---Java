package com.vitoz.offer;

public class Demo13 {
    public static void main(String[] args) {
        int threshold = 18;
        int rows = 7;
        int cols = 5;
//        System.out.println(getNodeNum(threshold, rows, cols));
        System.out.println(getDigit(123,0));
    }

    /**
     *@描述 对于给定行列的表格，以及行列数位和限制，判断机器人的活动格子数目
     *@参数  [输入门限值，输入总行数，输入总列数]
     *@返回值  机器人可以活动的格子数目
     *@创建人  vitoz
     *@创建时间  2018/8/30
     *@修改人和其它信息
     */
    private static int getNodeNum(int threshold, int rows, int cols){
        if (threshold<0 || rows<=0 || cols<=0){
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                visited[i][j] = false;
            }
        }
        return getNodeNumCore(threshold, rows, cols, 0, 0, visited);
    }

    /**
     *@描述 获取机器人在特定输入条件下所能活动的格子数目
     *@参数  [输入门限，总行数，总列数，当前行，当前列，路径访问二维数组]
     *@返回值  当前环境下机器人活动的格子数目
     *@创建人  vitoz
     *@创建时间  2018/8/30
     *@修改人和其它信息
     */
    private static int getNodeNumCore(int threshold, int rows, int cols, int row, int col, boolean[][] visited){
        int count = 0;
        if (row>=0 && row<rows && col>=0 && col<cols &&
                getDigit(row,0)+getDigit(col,0)<=threshold && !visited[row][col]){
            visited[row][col] = true;
            count = 1 + getNodeNumCore(threshold, rows, cols, row, col-1, visited)
                    + getNodeNumCore(threshold, rows, cols, row, col+1, visited)
                    + getNodeNumCore(threshold, rows, cols, row-1, col, visited)
                    + getNodeNumCore(threshold, rows, cols, row+1, col, visited);
        }
        return count;
    }

    /**
     *@描述 对于给定输入，得到其对应的数位之和（尾递归的方式）
     *@参数  [输入整数，初始时数位]
     *@返回值  整数对应数位
     *@创建人  vitoz
     *@创建时间  2018/8/30
     *@修改人和其它信息
     */
    private static int getDigit(int num, int res){
        return num <=0?res:getDigit(num/10, res+num%10);
    }
}
