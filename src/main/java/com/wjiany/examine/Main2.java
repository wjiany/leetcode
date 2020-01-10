package com.wjiany.examine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static int count = 0;
    public static List<List<Integer>> lists = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> coms = new ArrayList<>();
        for (int i = 1; i<num;i++){
            coms.add(sc.nextInt());
            arrayList.add(i);
        }
        arrayList.add(num);
        getList(arrayList,new ArrayList<>());
        for (int i =0;i<lists.size();i++){
            List<Integer> list = lists.get(i);
            int m = 0;
            for (int j = 0;j<list.size()-1;j++){
                if((coms.get(j) == 1&& list.get(j)<=list.get(j+1))
                ||(coms.get(j) == 0&& list.get(j)>=list.get(j+1))){
                    break;
                }
                m++;
            }
            if(m == list.size()-1){
                count++;
            }
        }
        System.out.println(count);
}
    public static void getList(List<Integer> nums ,List<Integer> list){
        int length = nums.size();
        int num = 0;
        for(int i = 0;i<length;i++){
            if(nums.get(i) == null){
                num++;
                continue;
            }
            List<Integer> numsCopy = new ArrayList<>();
            numsCopy.addAll(nums);
            numsCopy.set(i,null);
            List<Integer> listTemp = new ArrayList<>();
            listTemp.addAll(list);
            listTemp.add(nums.get(i));
            getList(numsCopy,listTemp);
        }
        if(num == length){
            lists.add(list);
        }
    }
}