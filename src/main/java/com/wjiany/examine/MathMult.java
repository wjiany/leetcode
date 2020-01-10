package com.wjiany.examine;
import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MathMult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        BigInteger score = new BigInteger("0");
        sc.nextLine();
        Queue<Ab> queue = new PriorityQueue<>(num,(x,y)->{return (x.getBefore(num)).compareTo(y.getBefore(num));});
        for (int i = 1;i <= num ;i++){
            queue.add(new Ab(sc.nextInt(),BigInteger.valueOf(sc.nextInt()),i));
            sc.nextLine();
        }
        queue.stream().forEach(x->System.out.println(x.getA()+":"+x.getB()));
        for (int i = 1 ; i<= num ;i++){
            Ab remove = queue.remove();
            BigInteger add = remove.getB().multiply(BigInteger.valueOf(num - i)).add(BigInteger.valueOf(remove.getA() * (i - 1)));
            score=score.add(add);
        }
        System.out.println(score);
    }
}

class Ab{
    private int a ;
    private BigInteger b ;
    private int index;

    public  Ab(int a ,BigInteger b,int index){
        this.a = a;
        this.b = b;
        this.index = index;
    }
    public int getA() {
        return a;
    }
    public BigInteger getB() {
        return b;
    }

    public int getIndex() {
        return index;
    }
    public BigInteger getBefore(int num){
        int i = this.getA() * (this.getIndex() - 1);
        return this.getB().multiply(BigInteger.valueOf(num-this.getIndex())).add(BigInteger.valueOf(i));
    }
}