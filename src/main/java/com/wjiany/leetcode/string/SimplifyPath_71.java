package com.wjiany.leetcode.string;

import org.junit.Test;

import java.util.Stack;

public class SimplifyPath_71 {

    @Test
    public void test(){
        System.out.println(simplifyPath_1("/home/"));
    }

    /**
     * 和题目不符合。题目是如果三个点，那么就是原来的样子。。。。。
     * Unix 中 mkdir /...  之后可以cd进入的。。。。
     * @param path
     * @return
     */

    public String simplifyPath_error(String path) {
        StringBuilder res = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int len = 0;
        for (int i = 1; i < path.length(); i++) {
            //处理  '.'
            if(path.charAt(i) == '.'){
                if(path.charAt(i-1) == '.' && stack.size() > 0){
                    stack.pop();
                }
                continue;
            }
            //处理   '/'
            if(path.charAt(i) != '/'){
                len++;
            }else {
                //  两个 ‘/’
                if(len !=0){
                    stack.add(path.substring(i-len,i));
                    len = 0;
                }
            }
        }
        if(len != 0) stack.add(path.substring(path.length()-len));
        if(stack.size()!=0){
            stack.stream().forEach(x->{res.append("/").append(x);});
            return res.toString();
        }else {
            return "/";
        }
    }
    public String simplifyPath_1(String path) {
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length; i++) {
            if (!stack.isEmpty() && s[i].equals(".."))
                stack.pop();
            else if (!s[i].equals("") && !s[i].equals(".") && !s[i].equals(".."))
                stack.push(s[i]);
        }
        if (stack.isEmpty())
            return "/";

        StringBuffer res = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            res.append("/" + stack.get(i));
        }
        return res.toString();
    }

}