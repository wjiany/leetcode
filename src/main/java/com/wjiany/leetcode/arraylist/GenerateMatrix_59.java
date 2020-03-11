package com.wjiany.leetcode.arraylist;

import org.junit.Test;

public class GenerateMatrix_59 {
    @Test
    public void test(){
        int[][] ints = generateMatrix(4);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int[][] generateMatrix(int n) {
        int leftB=0,upB=0;
        int rightB=n-1,bottonB=n-1;
        int[][] ints = new int[n][n];
        int num = 1;
        while (true){
            for (int i = leftB; i <= rightB; i++) {
                ints[upB][i] = num;
                num +=1;
            }
            if(++upB > bottonB) break;
            for (int i = upB; i <= bottonB; i++) {
                ints[i][rightB] = num;
                num +=1;
            }
            if(--rightB < leftB) break;
            for (int i = rightB; i >= leftB; i--) {
                ints[bottonB][i] = num;
                num +=1;
            }
            if(--bottonB < upB) break;
            for (int i = bottonB; i >= upB ; i--) {
                ints[i][leftB] = num;
                num +=1;
            }
            if(++leftB > rightB) break;
        }
        return ints;
    }
}