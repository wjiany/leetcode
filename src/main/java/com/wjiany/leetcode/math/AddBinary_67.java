package com.wjiany.leetcode.math;

import org.junit.Test;

public class AddBinary_67 {
    @Test
    public void  test(){
        System.out.println(addBinary_1("1","111"));
    }
    public String addBinary_1(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        int aIndex = alen-1;
        int bIndex = blen-1;
        int add = 0;
        StringBuilder res = new StringBuilder();
        while (aIndex>=0 || bIndex>=0){
            int aAdd = aIndex>=0?a.charAt(aIndex) - '0':0;
            int bAdd = bIndex>=0?b.charAt(bIndex) - '0':0;
            int sum = aAdd + bAdd + add;
            res.append(sum%2);
            add = sum/2;
            aIndex--;
            bIndex--;
        }
        if(add!=0) res.append(add);
        return res.reverse().toString();
    }

    /**
     * 原来写的
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        if(aLen>bLen){
            for (int i = 0;i<aLen-bLen;i++){
                b="0"+b;
            }
        }else {
            for (int i = 0;i<bLen-aLen;i++){
                a="0"+a;
            }
        }
        int add = 0;
        int m = 0;
        int n = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = Math.max(aLen,bLen)-1;i>=0;i--){
            m = a.charAt(i)-'0';
            n = b.charAt(i)-'0';
            int low = (m + n + add) % 2;
            int high = (m + n +add) / 2;
            sb.append(low);
            add = high;
        }
        if(add != 0){
            sb.append(add);
        }
        return sb.reverse().toString();
    }
}
