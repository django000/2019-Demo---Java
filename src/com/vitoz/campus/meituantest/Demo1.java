package com.vitoz.campus.meituantest;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
    }
}

/**
 * #include<bits/stdc++.h>
 * using namespace std;
 * int lst[100005];
 * int main(){
 *     int n;
 *     while(cin>>n){
 *         memset(lst,0,sizeof(lst));
 *         for(int i = 0;i<n-1;i++){
 *             int a,b;
 *             cin>>a>>b;
 *             lst[b] = lst[a]+1;
 *             }
 *             int depth = 0;
 *             for(int i = 1;i<=n;i++)
 *                 depth = lst[i]>depth?lst[i]:depth;
 *                 cout<<2*n-2-depth<<endl;
 *     }
 *     return 0;
 * }
 * */