package com.vitoz.offer;

public class Demo5 {
    public static void main(String[] args) {
        String str = "we are happy.";
        int lenStr = str.length();
        int lenArr = lenStr*3;
        char[] string = new char[lenArr];
        for (int i=0;i<lenStr;i++){
            string[i] = str.charAt(i);
        }
        replaceBlank(string, lenStr);
        for (int i=0;i<lenArr;i++){
            if (string[i] != ' '){
                System.out.print(string[i]);
            }
        }
    }

    public static void replaceBlank(char[] string, int len){
        if (string == null || string.length ==0){
            return ;
        }
        int count = 0;
        for (int i=0;i<len;i++){
            if (string[i] == ' '){
                count++;
            }
        }
        int newLen = len+count*2;
        if (newLen > string.length){
            return ;
        }
        int index = len - 1;
        int indexNew = newLen - 1;
        while (index >=0 && index<indexNew){
            if (string[index] == ' '){
                string[indexNew--] = '0';
                string[indexNew--] = '2';
                string[indexNew--] = '%';
            }else{
                string[indexNew--] = string[index];
            }
            index--;
        }
    }
}
