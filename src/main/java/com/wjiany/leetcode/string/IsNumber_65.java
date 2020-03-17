package com.wjiany.leetcode.string;

class IsNumber_65 {
    /**
     * 状态机方法，值得学习
     * @param s
     * @return
     */
    public boolean isNumber(String s) {

        //todo
    return false;
    }

    /**
     * 参考评论
     * 执行用时0ms，战胜了100%的C++提交 没有用自动机...分了三步来处理。
     * 第一步trim，即去除头尾的空格；
     * 第二步划分，找出字符e划分为底数和指数两部分；
     * 第三部判断底数和指数是否有效，若没有指数则指判断底数，显然指数只能包含符号和整数、
     * 而底数只能包含符号、小数点和数字。 代码看起来长，但实际上思路很简单...
     * @param s
     * @return
     */
    public boolean isNumber_1(String s) {
        int len = 0;//去除首尾空格
        for(int i = s.length() - 1; i >= 0; i--)
        {
            if(s.charAt(i) == ' ') len++;
            else break;
        }
        s = s.substring(0, s.length() - len);
        len = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == ' ') len++;
            else break;
        }
        s = s.substring(len);
        if(s.length() == 0) return false;

        int id = s.indexOf('e');//划分为底数和指数
        if(id == -1) return judgeP(s);//判断底数
        else return judgeP(s.substring(0, id)) && judgeS(s.substring(id + 1));//判断指数
    }
    private boolean judgeP(String s)
    {
        boolean res = false;
        boolean pointed = false;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '+' || s.charAt(i) == '-')
            {
                if(i != 0) return false;
            }
            else if(s.charAt(i) == '.')
            {
                if(pointed) return false;
                pointed = true;
            }
            else if(s.charAt(i) < '0' || s.charAt(i) > '9') return false;
            else res = true;
        }
        return res;
    }

    private boolean judgeS(String s)
    {
        boolean res = false;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '-' || s.charAt(i) == '+')
            {
                if(i != 0) return false;
            }
            else if(s.charAt(i) < '0' || s.charAt(i) > '9') return false;
            else res = true;
        }
        return res;
    }
}