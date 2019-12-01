package com.wjiany.leetcode.examine;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * n*m ,取k大
 */
public class P2Queue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int ceil = (int)Math.ceil(Math.sqrt(k));
        Queue<Integer> queue = new PriorityQueue<>(k,(x,y)->{return x-y;});
        for (int i = n;i>=ceil;i--){
            for (int j=m;j>=ceil;j--){
                if (queue.size()!=k){
                    queue.add(i*j);
                }else {
                    if (queue.peek()<i*j){
                        queue.poll();
                        queue.add(i*j);
                    }
                }
            }
        }
        System.out.println(queue.peek());
    }
}