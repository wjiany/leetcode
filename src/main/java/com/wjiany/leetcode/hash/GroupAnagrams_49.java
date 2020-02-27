package com.wjiany.leetcode.hash;

import org.junit.Test;

import java.util.*;

public class GroupAnagrams_49 {

    @Test
    public void test(){
        groupAnagrams(new String[]{"old", "her"}).stream().forEach(x->{
            System.out.println("====");
            x.stream().forEach(System.out::println);
        });
    }

    /**
     * 官方答案
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
    /**
     * 有的案例没有通过
     * 相加和相乘都相等，这三个数并不一定相同
     * 8 5 18 ，15 12 4
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        Map<Long,List<String>> map = new HashMap<>();
        long[] hasAp = new long[strs.length];
        for (int i = 0; i < strs.length; i++) {
            int tmp1 = 0;//加法和乘法满足交换律 与顺序无关
            int tmp2 = 1;
            for (int j = 0; j < strs[i].length(); j++) {
                int index = strs[i].charAt(j) - 'a' + 1;
                System.out.println(index+":index");
                tmp1 +=index;
                tmp2 *=index;
            }
            hasAp[i] = (tmp2<<7) | tmp1;
            System.out.println((tmp2<<7)+":7<<tm2");
            System.out.println(tmp2+":tm2");
            System.out.println(tmp1+":tm1");
            System.out.println(Integer.toBinaryString((tmp2<<7))+":7<<tm2");
            System.out.println(Integer.toBinaryString((tmp1))+":tm1");
            System.out.println(Long.toBinaryString(hasAp[i])+":has");
            System.out.println("------------");
            if(!map.containsKey(hasAp[i])){
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                lists.add(list);
                map.put(hasAp[i],list);
            }else {
                List<String> list = map.get(hasAp[i]);
                list.add(strs[i]);
            }
        }
        return lists;
    }
}