package com.wjiany.examine;
import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bao = sc.nextInt();
        int yao = sc.nextInt();
        int baoJi = 0;
        int baoOu = 0;
        int yaoJi = 0;
        int yaoOu = 0;
        sc.nextLine();
        for (int i = 0 ;i <bao;i++){
            if(sc.nextInt() % 2== 0){
                baoOu++;
            }else baoJi++;
        }
        sc.nextLine();
        for (int i = 0 ;i <yao;i++){
            if(sc.nextInt() % 2== 0){
                yaoOu++;
            }else yaoJi++;
        }
    System.out.println(Math.min(baoJi,yaoOu)+Math.min(baoOu,yaoJi));
    }
}