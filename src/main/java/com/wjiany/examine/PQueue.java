package com.wjiany.examine;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 偶数大于奇数，同类大的大，取前n
 */
public class PQueue {
    public void prQUeue(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        int length = split.length;
        String[] split1 = split[length - 1].split(";");
        split[length-1] = split1[0];
        int n = Integer.valueOf(split1[1]);
        Queue<Integer> queue = new PriorityQueue<>(100,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if((o1 % 2 ==0 && o2 %2==0)||(o1 % 2 ==1 && o2 %2==1)){
                    return o2-o1;
                }
                if(o1 % 2 ==0 ) return -1;
                return 1;
            }
        });
        for (int i = 0; i< length ;i++){
            queue.add(Integer.valueOf(split[i]));
        }
        for (int i = 0; i< n ;i++){
            System.out.print(queue.remove());
            if(i!=n-1){
                System.out.print(",");
            }
        }
    }
}