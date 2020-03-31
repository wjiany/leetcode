package com.wjiany.examine;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String anInt = sc.next();
        char[] tmpChars = new char[n];
        for (int i = 0; i < n; i++) {
            tmpChars[i] = anInt.charAt(i);
        }
        for (int i = 0; i < m; i++) {
            sc.nextLine();
            String next = sc.next();
            if(next.equals("q")){
                System.out.println(fun(tmpChars));
            }else if(next.equals("c")){
                int start = sc.nextInt()-1;
                int end = sc.nextInt()-1;
                for (int j = start; j <= end; j++) {
                    tmpChars[j] = tmpChars[j] == '0'?'1':'0';
                }
            }
        }

    }

    private static int fun(char[] chars) {
        int max = 1;
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if(chars[i] >= chars[i-1]){
                count++;
                max = Math.max(max,count);
            }else {
                count=1;
            }
        }
        return max;
    }
}
