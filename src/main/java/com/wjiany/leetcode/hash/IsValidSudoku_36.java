package com.wjiany.leetcode.hash;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsValidSudoku_36 {

    @Test
public void test(){
        boolean validSudoku1 = isValidSudoku1(new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}});
        System.out.println(validSudoku1);
    }
    /**
     *热心网友
     * 直接就用移位编码来做，用int表示集合，通过按位与判断行、列、宫格是否重复，
     * 通过按位或加入数字对应的集合，只用一维数组的额外空间，所有字符元素只过一遍
     *todo 有待理解
     * https://leetcode-cn.com/problems/valid-sudoku/solution/javabian-ma-yong-intbiao-shi-ji-he-yong-wei-yun-su/
     */
        public boolean isValidSudoku1(char[][] board) {
            if(board == null)
                return false;
            if(board.length !=9)
                return false;
            int[] map = new int[9];
            for(int y=0; y<9; y++){
                if(board[y] == null || board[y].length != 9)
                    return false;
                for(int x=0; x<9; x++){
                    int key = board[y][x] - '1'; //key:数字
                    /*
                    1~9有效数字  则 0-8
                    index保留的是key的位置编码 Value:位置编码，x最低9位存放列号 0-8    0-    1 0  0  0
                    y中间9位存放行号              （0-8）+9 =9-17            1 0 0 1 - 1 0 0 0 1
                    z为9宫格区域序号    1 0 0 0 1 - 0 1 1 1 1 0
                     */
                    if(key >= 0 && key <= 8) {
                        int index = (1<<x)
                                | (1<<(y+9))
                                | (1<<(x/3 + y/3*3 + 18));
                        int old = map[key];
                        if((old & index) == 0) //无重复，则按位或，加入位置集合
                            map[key] = old | index;
                        else    //有重复
                            return false;
                    }
                }
            }
            return true;
        }
    /**
     *
     * 官方
     * 行 9个map
     * 列 9个map
     * box 9个map
     * @param board
     * @return
     */
        public boolean isValidSudoku(char[][] board) {
            // init data
            HashMap<Integer, Integer> [] rows = new HashMap[9];
            HashMap<Integer, Integer> [] columns = new HashMap[9];
            HashMap<Integer, Integer> [] boxes = new HashMap[9];
            for (int i = 0; i < 9; i++) {
                rows[i] = new HashMap<>();
                columns[i] = new HashMap<>();
                boxes[i] = new HashMap<>();
            }

            // validate a board
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char num = board[i][j];
                    if (num != '.') {
                        int n = (int)num;
                        int box_index = (i / 3 ) * 3 + j / 3;

                        // keep the current cell value
                        rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                        columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                        boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                        // check if this value has been already seen before
                        if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                            return false;
                    }
                }
            }

            return true;
        }
}