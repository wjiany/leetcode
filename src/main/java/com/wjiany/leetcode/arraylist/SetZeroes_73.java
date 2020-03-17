package com.wjiany.leetcode.arraylist;

import org.junit.Test;

public class SetZeroes_73 {
    @Test
    public void test(){
        int[][] ints = {{0,1,2,0}, {3,4,5,2}, {1, 3,1,5}};
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                System.out.print(ints[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("-------------------");
        setZeroes_2(ints);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                System.out.print(ints[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * 对1进行了优化
     * @param matrix
     */
    public void setZeroes_2(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //' ' 表示原来这个位置 是1
                if(matrix[i][j] == 0){
                    for (int k = 0; k < matrix[0].length; k++) {
                        if(matrix[i][k] != 0) {
                            matrix[i][k] = ' ';
                        }
                    }
                    for (int k = 0; k < matrix.length; k++) {
                        if(matrix[k][j] != 0) {
                            matrix[k][j] = ' ';
                        }
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == ' ') matrix[i][j] = 0;
            }
        }
    }
    /**
     * 原地改变的方法 ，自己写的，效率感人。。。
     * @param matrix
     */
    public void setZeroes_1(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //' ' 表示原来这个位置 是1
                if(matrix[i][j] == 0){
                    for (int k = 0; k < matrix[0].length; k++) {
                        if(k < j) matrix[i][k] = 0;
                        else if(k > j && (matrix[i][k] != 0 || matrix[i][k] == ' ')) {
                             matrix[i][k] = ' ';
                        }
                    }
                    for (int k = 0; k < matrix.length; k++) {
                       if(k < i) matrix[k][j] = 0;
                       else if(k > i && (matrix[k][j] != 0 || matrix[k][j] == ' ')) {
                           matrix[k][j] = ' ';
                       }
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == ' ') matrix[i][j] = 0;
            }
        }
    }
}