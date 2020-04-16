package com.wjiany.leetcode.Array2P;

public class SearchMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowNum = matrix.length;
        if(rowNum == 0) return false;
        int colNum = matrix[0].length;
        if(colNum == 0) return false;
        int left = 0;
        int right = colNum-1;
        int up = 0;
        int down = rowNum-1;
        if(matrix[up][left] > target) return false;
        if(matrix[down][right] < target) return false;
        while (up < down){
            int min = matrix[up][left];
            int max = matrix[down][right];
            if(min == target || max == target) return true;
            if(left == colNum-1){
                left=0;
                up++;
            }else {
                left++;
            }
            if(right == 0){
                right = colNum-1;
                down--;
            }else {
                right--;
            }
        }
        while (up == down){
            if(matrix[up][left] == target) return true;
            if(matrix[down][right] == target) return true;
            left++;
            right--;
            if(left > right) return false;
        }
        return false;
    }
}