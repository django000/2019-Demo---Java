package com.vitoz.offer.chapter2;

public class Demo5 {
    public static void main(String[] args) {
        String str = "we are happy.";
        char[] input = str.toCharArray();
        int len = input.length;
        char[] output = new char[len*3];
        for (int i=0;i<len;i++){
            output[i] = input[i];
        }
        replaceBlank(output, len);
        for (int i=0;i<output.length;i++){
            if (output[i] != ' '){
                System.out.print(output[i]);
            }
        }
        System.out.println();
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
