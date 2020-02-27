package com.wjiany.leetcode.arraylist;

import org.junit.Test;

import java.util.Arrays;

/**
 * 顺时针 ： 转置 -》 横坐标 交换
 * 逆时针 ： 转置 -》 纵坐标 交换
 */
public class Rotate_48 {

    @Test
    public void test(){
        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(ints);
        Arrays.asList(ints).stream().forEach(x->{
            System.out.println("====");
            for (int i = 0; i < x.length; i++) {
                System.out.print(x[i]+"   ");
            }
            System.out.println();
        });
    }

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                if (i != j){
                    rotateTwo(matrix,i,j,j,i);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                rotateTwo(matrix,i,j,i,matrix.length-j-1);
            }
        }

    }
    private void rotateTwo(int[][] nums,int i,int j,int m,int n){
        int tmp = nums[i][j];
        nums[i][j] = nums[m][n];
        nums[m][n] = tmp;
    }
}