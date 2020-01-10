package com.wjiany.examine;

import java.util.Scanner;

/**
 * true or false and true
 * and 优先级大于 or
 */
public class MainOrAnd {
    static String or = "or";
    static String and = "and";
    static String t = "true";
    static String f = "false";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int length = strings.length;
        if (length%2==0){
            System.out.println("error");
            return;
        }
        for(int i = 0;i<strings.length;i++){
            if(i%2==0&&funTF(strings[i])){
                continue;
            }else if(i%2==1&&funOA(strings[i])){
                if(funTF(strings[i+1])){
                    if(strings[i].equals(and)&&strings[i-1].equals(t)&&strings[i+1].equals(t)){
                        strings[i-1] = t;
                        strings[i+1] = t;
                    }else {
                        strings[i-1] = f;
                        strings[i+1] = f;
                    }
                }else {
                    System.out.println("error");
                    return;
                }
            }else {
                System.out.println("error");
                return;
            }
        }
        for (String s : strings){
            if(s.equals(t)){
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }
    public static boolean funOA(String string){
            return string.equals(or)||string.equals(and);
    }
    public static boolean funTF(String string){
            return string.equals(t)||string.equals(f);
    }
}
