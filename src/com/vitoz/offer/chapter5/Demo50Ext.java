package com.vitoz.offer.chapter5;

/**
 * @Auther: vitoz
 * @Date: 2018/10/20 17:51
 * @Description: 剑指offer面试题50扩展——字符流中第一个出现的字符
 */
public class Demo50Ext {
    private int index;
    private int[] hashTable;
    public Demo50Ext(){
        index = 0;
        hashTable = new int[256];
        for (int i=0;i<256;i++){
            hashTable[i] = -1;
        }
    }

    /**
     *@描述  插入字符的函数
     *@参数  [ch]
     *@返回值  void
     *@创建人  vitoz
     *@创建时间  2018/10/20
     *@修改人和其它信息
     */
    public void insert(char ch){
        if (hashTable[ch] == -1){
            hashTable[ch] = index;
        }else if (hashTable[ch] >= 0){
            hashTable[ch] = -2;
        }
        index++;
    }

    /**
     *@描述  遍历hashTable获取第一次出现的字符
     *@参数  []
     *@返回值  char
     *@创建人  vitoz
     *@创建时间  2018/10/20
     *@修改人和其它信息
     */
    public char getFirstNotRepeatingChar(){
        char ch = '\u0000';
        int maxIndex = index;
        for (int i=0;i<256;i++){
            if (hashTable[i]>=0 && hashTable[i]<maxIndex){
                ch = (char)i;
                maxIndex = hashTable[i];
            }
        }
        return ch;
    }
}
