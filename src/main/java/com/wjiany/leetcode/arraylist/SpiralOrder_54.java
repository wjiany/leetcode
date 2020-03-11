package com.wjiany.leetcode.arraylist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SpiralOrder_54 {

    @Test
    public void test(){
     spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}).stream().forEach(System.out::println);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if(matrix.length==0)    return result;
        int upBound = 0;
        int rightBound = matrix[0].length-1;
        int leftBound = 0;
        int downBound = matrix.length-1;

        /**
         * 左边界超过右边界 或者  下边界超过上边界
         * 右边界超过左边界 或者  上边界超过下边界    break
         *
         * 加第一行 ，上边界 +1；
         * 加最后一列 ，右边界 -1；
         *  倒 加最后一行，下边界 -1
         *  倒  加第一列 ，左边界+1
         */
        while(true){
            for(int i=leftBound; i<=rightBound; ++i)
                result.add(matrix[upBound][i]);
            if(++upBound>downBound) break;
            for(int i=upBound; i<=downBound; ++i)
                result.add(matrix[i][rightBound]);
            if(--rightBound<leftBound)  break;
            for(int i=rightBound; i>=leftBound; --i)
                result.add(matrix[downBound][i]);
            if(--downBound<upBound) break;
            for(int i=downBound; i>=upBound; --i)
                result.add(matrix[i][leftBound]);
            if(++leftBound>rightBound)  break;
        }
        return result;
    }
    //只能边缘输出,有问题
    public List<Integer> spiralOrder_error(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int total = rows * cols;
        List<Integer> list = new ArrayList<>();
        int direction = 0; ///0 👉，1 👇，2 👈，3 👆
        int rowIndex = 0,colIndex = 0;
        boolean[][] seen = new boolean[rows][cols];
        while (total > 0){
            if(!seen[rowIndex][colIndex]){
                list.add(matrix[rowIndex][colIndex]);
                total--;
                seen[rowIndex][colIndex] = true;
            }
            if(direction == 0){
                colIndex ++;
            }else if(direction == 1){
                rowIndex++;
            }else if(direction == 2){
                rowIndex--;
            }else if(direction == 3){
                colIndex--;
            }
            if(colIndex == cols && direction == 0){
                colIndex = cols-1;
                direction = 1;
            }else if(rowIndex == rows && direction == 1){
                rowIndex = rows-1;
                direction = 2;
            }else if(colIndex == -1 && direction == 2){
                colIndex = 0;
                direction = 3;
            }else if(rowIndex == -1 && direction == 3){
                rowIndex = 0;
                direction = 0;
            }
        }
        return list;
    }
}