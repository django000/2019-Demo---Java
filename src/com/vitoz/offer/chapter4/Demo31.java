package com.vitoz.offer.chapter4;

import java.util.Stack;

/**
 * @Auther: vitoz
 * @Date: 2018/9/2 00:41
 * @Description: 剑指offer面试题31——判断栈的压入序列与弹出序列是否对应
 */
public class Demo31 {
    public static void main(String[] args) {
        int[] pushArr = {1,2,3,4,5};
        int[] popArr = {4,3,5,2,1};
        System.out.println(isPopOrder(pushArr, popArr));
    }

    /**
     *@描述
     *@参数  [栈的压入序列, 栈的弹出序列]
     *@返回值  boolean
     *@创建人  vitoz
     *@创建时间  2018/9/2
     *@修改人和其它信息
     */
    private static boolean isPopOrder(int[] pushArr, int[] popArr){
        boolean result = false;
        if (pushArr != null && popArr != null && pushArr.length >0 && pushArr.length == popArr.length){
            int pushInd = 0;
            int popInd = 0;
            int len = pushArr.length;
            Stack<Integer> stack = new Stack<>();
            while (popInd < len){
                // 栈为空或者当前栈顶元素不等于popArr中元素，则push元素直至pushArr遍历完或者栈顶元素和popArr中对应元素相等
                while (stack.isEmpty() || stack.peek() != popArr[popInd]){
                    if (pushInd == len){
                        break;
                    }
                    stack.push(pushArr[pushInd++]);
                }
                // 如果栈顶元素仍旧不相等，则进行二次break
                if (stack.peek() != popArr[popInd]){
                    break;
                }
                stack.pop();
                popInd++;
            }
            // 判断数据栈是否为空且popArr序列中索引已经走到最后
            if (stack.isEmpty() && popInd == len){
                result = true;
            }
        }
        return result;
    }
}
