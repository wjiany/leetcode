package com.wjiany.examine;


import java.util.Scanner;

public class Meituan3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int p = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        int[] kNum = new int[k];
        for (int i = 0; i < k; i++) {
            kNum[i] = sc.nextInt();
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int lastTime = m;
            int count = 0;
            for (int j = 0; j < k; j++) {
                 lastTime = m - kNum[j];
                if(lastTime>=0){
                    max += p;
                    m = lastTime;
                    count++;
                }
            }
            if( count == k){
                max += q;
            }
        }
        System.out.println(max);
    }

}
