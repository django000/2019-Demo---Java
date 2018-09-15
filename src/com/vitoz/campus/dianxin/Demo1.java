package com.vitoz.campus.dianxin;


import java.util.Scanner;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 22:00
 * @Description: 电信笔试题1
 */
public class Demo1 {
    private static int index = -1;
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine().trim();
        String str = "abc##de#g##f###";
        TreeNode root = Deserialize(str);
        StringBuilder builder = new StringBuilder();
        root.printInorder(builder);
        System.out.println(builder.toString().trim()+"111");
    }

    private static TreeNode Deserialize(String str) {
        index++;
        char[] arr = str.toCharArray();
        TreeNode leave = null;
        if(arr[index] != '#'){
            leave = new TreeNode(String.valueOf(arr[index]));
            leave.left = Deserialize(str);
            leave.right = Deserialize(str);
        }
        return leave;
    }
}
class TreeNode{
    public String value;
    public TreeNode left = null;
    public TreeNode right = null;
    public TreeNode(String value){
        this.value = value;
    }

    public void printInorder(StringBuilder builder){
        if (left != null){
            left.printInorder(builder);
        }
        builder.append(value+" ");
        if (right != null){
            right.printInorder(builder);
        }
    }
}
