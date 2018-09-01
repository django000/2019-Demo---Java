package com.vitoz.offer.chapter4;

/**
 * @Auther: vitoz
 * @Date: 2018/9/1 23:27
 * @Description: 剑指offer面试题29——顺时针打印矩阵
 */
public class Demo29 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printMatrixClock(matrix, false);
    }

    /**
     *@描述  对于给定的二维矩阵以及打印顺序，进行顺时针或逆时针的打印
     *@参数  [输入二维矩阵, 是否顺时针]
     *@返回值  void
     *@创建人  vitoz
     *@创建时间  2018/9/1
     *@修改人和其它信息
     */
    private static void printMatrixClock(int[][] matrix, boolean isClockwise){
        if (matrix == null || matrix.length == 0 || (matrix.length ==1 && matrix[0].length == 0)){
            return;
        }
        int start = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        while (cols > 2*start && rows > 2*start){
            if (isClockwise){
                printMatrixIncircle(matrix, start);
            }else {
                printMatrixAntiIncircle(matrix, start);
            }
            start++;
        }
    }
    /**
     *@描述  对于给定矩阵的打印起始点坐标，顺时针打印一圈
     *@参数  [输入二维矩阵, 打印点起始坐标]
     *@返回值  void
     *@创建人  vitoz
     *@创建时间  2018/9/1
     *@修改人和其它信息
     */
    private static void printMatrixIncircle(int[][] matrix, int start){
        // 正常情况下这里应当有对matrix和start的校验，我暂时省略了
        int endX = matrix[0].length - 1 - start;
        int endY = matrix.length - 1 - start;

        // 从左到右打印一行
        for (int i=start;i<=endX;i++){
            System.out.print(matrix[start][i]+" ");
        }
        // 从上到下打印一列
        if (start < endY){
            for (int i=start+1;i<=endY;i++){
                System.out.print(matrix[i][endX]+" ");
            }
        }
        // 从右到左打印一行
        if (start < endX){
            for (int i=endX-1;i>=start;i--){
                System.out.print(matrix[endY][i]+" ");
            }
        }
        // 从下到上打印一列
        if (start < endY - 1){
            for (int i=endY-1;i>=start+1;i--){
                System.out.print(matrix[i][start]+" ");
            }
        }
    }
    /**
     *@描述  对于给定矩阵的打印起始点坐标，顺时针打印一圈
     *@参数  [输入二维矩阵, 打印点其起始坐标]
     *@返回值  void
     *@创建人  vitoz
     *@创建时间  2018/9/1
     *@修改人和其它信息
     */
    private static void printMatrixAntiIncircle(int[][] matrix, int start){
        // 正常情况下这里应当有对matrix和start的校验，我暂时省略了
        int endX = matrix[0].length - 1 - start;
        int endY = matrix.length - 1 - start;

        // 从上到下打印一列
        for (int i=start;i<=endY;i++){
            System.out.print(matrix[i][start]+" ");
        }
        // 从左到右打印一行
        if (start < endX){
            for (int i=start+1;i<=endX;i++){
                System.out.print(matrix[endY][i]+" ");
            }
        }
        // 从下到上打印一列
        if (start < endY){
            for (int i=endY-1;i>=start;i--){
                System.out.print(matrix[i][endX]+" ");
            }
        }
        // 从右到左打印一行
        if (start < endX - 1){
            for (int i=endX-1;i>=start+1;i--){
                System.out.print(matrix[start][i]+" ");
            }
        }
    }
}
