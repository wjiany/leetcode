package com.wjiany.leetcode.math;

import java.util.ArrayList;
import java.util.List;

public class PlusOne_66 {
    /**
     * 参考其他人
     * @param digits
     * @return
     */
    public int[] plusOne_1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] plusOne(int[] digits) {
        int add = 1;
        List<Integer> list = new ArrayList<>();
        for(int i = digits.length-1;i>=0;i--){
            int sum = digits[i] + add;
            int high = sum / 10;
            int low = sum % 10;
            list.add(low);
            add = high;

        }
        if(add != 0){
            list.add(add);
        }
        int[] res = new int[list.size()];
        for (int  i = 0;i<res.length;i++){
            res[i] = list.get(res.length-i-1);
        }
        return res;
    }
}
