package com.wjiany.leetcode.examine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        int[] ints = new int[num-1];
        for (int i = 0; i < num-1; i++) {
            ints[i] = sc.nextInt();
        }
        System.out.println(permute(num,ints));;
    }
    public static List<List<Integer>> res = new ArrayList<>();
    public  static boolean[] used;

    public static int permute(int N, int[] nums) {
        used = new boolean[N];
        helper(nums, 0, new ArrayList<>());
        return res.size();
    }

    public static void helper(int[] nums, int index, List<Integer> sub) {
        if (index == used.length) {
            res.add(new ArrayList<>(sub));
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (index == 0) {
                if (!used[i]) {
                    used[i] = true;
                    sub.add(i);
                    helper(nums, index + 1, sub);
                    used[i] = false;
                    sub.remove(sub.size() - 1);
                }
            } else {
                if (!used[i] && ((nums[index - 1] == 1 && i < sub.get(sub.size() - 1)) || (nums[index - 1] == 0 && i > sub.get(sub.size() - 1)))) {
                    used[i] = true;
                    sub.add(i);
                    helper(nums, index + 1, sub);
                    used[i] = false;
                    sub.remove(sub.size() - 1);
                }
            }
        }
    }
}
