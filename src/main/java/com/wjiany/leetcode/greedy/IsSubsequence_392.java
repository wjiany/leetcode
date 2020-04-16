package com.wjiany.leetcode.greedy;

class IsSubsequence_392 {
    public boolean isSubsequence(String s, String t) {

        int slen = s.length();
        int tlen = t.length();
        int sindex = 0;
        int tindex = 0;
        while (sindex < slen && tindex < tlen){
            if(s.charAt(sindex) == t.charAt(tindex)){
                sindex++;
                tindex++;
            }else {
                tindex++;
            }
        }
        return sindex == slen;

    }

    /**
     * https://leetcode-cn.com/problems/is-subsequence/solution/zhi-xing-yong-shi-0-ms-zai-suo-you-java-ti-jiao-77/
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence_1(String s, String t) {
        char[] arr = s.toCharArray();
        int j = -1;
        for(int i = 0;i<arr.length;i++) {
            j = t.indexOf(arr[i],j+1);
            if(j==-1) {
                return false;
            }
        }
        return true;
    }

}