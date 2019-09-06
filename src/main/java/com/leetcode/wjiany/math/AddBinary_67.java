package com.leetcode.wjiany.math;

import org.junit.Test;

public class AddBinary_67 {
    @Test
    public void  test(){
        System.out.println(addBinary("1","111"));
    }
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
