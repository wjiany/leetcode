package com.wjiany.leetcode.string;

import org.junit.Test;

import java.util.*;

public class FindSubstring_30 {


    @Test
    public void test(){
        List<Integer> integerList = findSubstring("barbarfoobarman", new String[]{"bar","foo"});
        integerList.stream().forEach(System.out::println);

    }

    /**
     * 自己写的回溯法，，超时。。。。
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if(s.length() == 0 || words.length  == 0){
            return list;
        }
        Set<String> set = new HashSet<>();
        findSubstring(words,0,new boolean[words.length],"",set);
        set.stream().forEach(x->{
            List<Integer> contains = containsWith(s, x);
            if(contains != null){
                list.addAll(contains);
            }
        });
        return list;
    }
    private void findSubstring(String[] words, int times, boolean[] used, String wordRes, Set set){
        if(times == words.length){
            set.add(wordRes);
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if(used[i]) continue;
            used[i] = true;
            findSubstring(words,times+1,used,wordRes+words[i],set);
            used[i] = false;
        }
    }
    /**
     * 不包含 -1
     * 包含 起始坐标
     * @param str
     * @param word
     * @return
     */
    private List<Integer> containsWith(String str, String word) {
        int resLen = str.length();
        int wordLen = word.length();
        if(resLen<wordLen) return null;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= resLen-wordLen; i++) {
            if (str.substring(i, i+wordLen).equals(word)) {
                list.add(i);
            };
        }
        return list.isEmpty()?null:list;
    }

    //不是我做的
    public List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int wordNum = words.length;
        if (wordNum == 0) {
            return res;
        }
        int wordLen = words[0].length(); //长度相同
        //HashMap1 存所有单词
        HashMap<String, Integer> allWords = new HashMap<String, Integer>();
        for (String w : words) {
            int value = allWords.getOrDefault(w, 0);
            allWords.put(w, value + 1);
        }
        //遍历所有子串
        for (int i = 0; i < s.length() - wordNum * wordLen + 1; i++) {
            //HashMap2 存当前扫描的字符串含有的单词
            HashMap<String, Integer> hasWords = new HashMap<String, Integer>();
            int num = 0;
            //判断该子串是否符合
            while (num < wordNum) {
                String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                //判断该单词在 HashMap1 中
                if (allWords.containsKey(word)) {
                    int value = hasWords.getOrDefault(word, 0);
                    hasWords.put(word, value + 1);
                    //判断当前单词的 value 和 HashMap1 中该单词的 value
                    if (hasWords.get(word) > allWords.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }
            //判断是不是所有的单词都符合条件
            if (num == wordNum) {
                res.add(i);
            }
        }
        return res;
    }
}