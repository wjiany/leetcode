package com.wjiany.examine;
import java.math.BigDecimal;
import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int red = sc.nextInt();
        int blue = sc.nextInt();
        System.out.println(solution(red,blue));
}
    public static double solution(int m, int n){
        double res = method(m,n);
        BigDecimal b=new BigDecimal(res);
        res=b.setScale(5,BigDecimal.ROUND_HALF_UP).doubleValue();
        return res;
    }
    public static double method(int m, int n){//m red; n blue
        if(m==0) return 0;
        else if(n==0) return 1.0;
        else if(n==1) return ((double)m/(m+1));
        else if(n==2) {
            if(m>1) return (1-(double)m*n/((m+n)*(m+n-1)));
            else return 1.0/3;
        }

        return ((double)m/(m+n))+ (double)(n*(n-1)*(n-2))/ ((m + n) * (m + n - 1) * (m + n - 2)) *method(m,n-3) +((double)(n*(n-1)*m)/ ((m + n) * (m + n - 1) * (m + n - 2)) *method(m-1,n-2));
    }
}