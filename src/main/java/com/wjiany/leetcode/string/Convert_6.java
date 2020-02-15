package com.wjiany.leetcode.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Convert_6 {
    @Test
    public void test(){
        System.out.println(convert("LEETCODEISHIRING",3));
    }
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();

        int rowNum = Math.min(numRows,s.length());
        for (int i = 0;i<rowNum;i++){
            list.add(new StringBuilder());
        }
        int rowChange = 0;
        boolean down = false;
        for (int i=0 ; i<s.length() ; i++){
            list.get(rowChange).append(s.charAt(i));
            if(rowChange == 0 || rowChange == rowNum-1){
                down = !down;
            }
            if(down){
                rowChange++;
            }else rowChange--;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0;i<list.size();i++){
            res.append(list.get(i));
        }
        return res.toString();
    }
}