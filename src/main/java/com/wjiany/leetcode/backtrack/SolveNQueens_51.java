package com.wjiany.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolveNQueens_51 {
        boolean[] col = null;  //这一列有没有Queen
        boolean[] left = null;//次对角线有没有
        boolean[] right = null; //主对角线有没有Q   一共 2n-1个主对角线
        List<List<String>> ret = new ArrayList<>();

        //看的答案
        public List<List<String>> solveNQueens(int n) {
            col = new boolean[n];
            left = new boolean[2*n-1];
            right = new boolean[2*n-1];
            char[][] board = new char[n][n];
            backTrack(board, 0, n);
            return ret;
        }

        private void backTrack(char[][] board, int r, int n) {
            if (r >= n) {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    list.add(new String(board[i]));
                }
                ret.add(list);
                return;
            }
            Arrays.fill(board[r], '.');
            for (int i = 0; i < n; i++) {  //对于行r 遍历每一列i
                //对于所有的主对角线有 行号 - 列号 = 常数，对于所有的次对角线有 行号 + 列号 = 常数
                if (!col[i] && !left[r + i] && !right[r - i + n - 1]) {
                    board[r][i] = 'Q';
                    col[i] = true;
                    left[r + i] = true;
                    right[r - i + n - 1] = true;
                    backTrack(board, r + 1, n);
                    board[r][i] = '.';
                    col[i] = false;
                    left[r + i] = false;
                    right[r - i + n - 1] = false;
                }
            }
        }
}