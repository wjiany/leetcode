package com.wjiany.leetcode.backtrack;

import org.junit.Test;

public class IsMatch_10 {

    @Test
    public void test(){
        //"a"调用subString(1)，返回"",不会报错，""调用subString(1)会报错
        System.out.println(isMatch("aa","a*"));
    }

    /**
     *
     * 1，p为空，s为空，则true
     * 2，p不为空， 判断P后有*还是无*
     *          有*  ，则判断0个（此时s可以为空）还是多个匹配（头匹配后面也要匹配）
     *          无*  ，头匹配 后面还要匹配
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        boolean firstMatch = !s.isEmpty()&&( s.charAt(0) == p.charAt(0) || p.charAt(0)=='.');
        //.*匹配0个或者多个  fistMatch为假，后面一定有*才肯成功
        //p>2或者后位有*
        //P<2,有*；p<2,无*（默认不可以，一位不可能是*）  ；p>2,无*
        if(p.length()>=2&&p.charAt(1) == '*'){
            return isMatch(s,p.substring(2)) || (firstMatch && isMatch(s.substring(1),p));
        }else {//p>2 ,无*
            return firstMatch && isMatch(s.substring(1),p.substring(1));
        }
    }
}
