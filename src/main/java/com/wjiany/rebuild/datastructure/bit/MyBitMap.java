package com.wjiany.rebuild.datastructure.bit;

import org.junit.Test;

//https://blog.csdn.net/woshilijiuyi/article/details/88778214

/**
 * 解决大数据量比较问题
 * 1，多文件分别比较处理；
 * 2，位图处理。
 *
 *
 * 此外，可以直接使用BitSet，内部使用的是long类型来保存bit，因此判断Byte位置时wordIndex是除以64，ADDRESS_BITS_PER_WORD ：即>>6，而不是5
 * 求余数时候 64-1，而不是 32-1，
 */

public class MyBitMap {
    @Test
    public void myBitMapTest(){
        MyBitMap myBitMap = new MyBitMap(1000);
        myBitMap.set1(99);
        System.out.println(myBitMap.isExist(99));
    }

    private int[] arrayBytes;
    public MyBitMap(){};// Java 写了有参构造器就不会有无参了，要显示写出来，不写的话，junit4 会报错
     MyBitMap(int size){
        arrayBytes = new int[size/32+1];
    }
    //不存在某个数，将第几个位置为0
    public void set0(int num){
        int indexByte = num >> 5;// 第几个字节，（除以32的商）（0-31，每个int）
        int indexBit = num & 31;  //第几位，（除以32得到的余数）
        arrayBytes[indexByte] &= ~(1<< indexBit);  //将某位置置 0 ，1往左位移，然后取反，然后与原数且运算
    }
    public void set1(int num){
        int indexByte = num >> 5;// 第几个字节，（除以32的商）（0-31，每个int）
        //方法一：
        int indexBit = num & 31;  //第几位，（除以32得到的余数）
        arrayBytes[indexByte] |= 1<< indexBit;   //将某位置置 1 ，1往左位移，然后与原数或运算
        //方法二：因为往左位移的时候，32的倍数自动清除了，即最高位，类似省略了求 余数 num & 31，即不够32的位数
        arrayBytes[indexByte] |= 1<< num;   //将某位置置 1 ，1往左位移，然后与原数或运算，
    }

    public boolean isExist(int num){
        int indexByte = num >> 5;// 第几个字节，（除以32的商）（0-31，每个int）
        int indexBit = num & 31;  //第几位，（除以32得到的余数）
        return (arrayBytes[indexByte] & (1<<indexBit)) == 0 ? false :true;  //判断是否含有这个数，即第几位是否为1
    }

    //把一个10进制数转为32位的2进制数
    //>>表示右移，如果该数为正，则高位补0，若为负数，则高位补1；
    //>>>表示无符号右移，也叫逻辑右移，即若该数为正，则高位补0，而若该数为负数，则右移后高位同样补0
    public static String get32BitString(int num){
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i< 32 ;i++){
            sb.append(num & 1);
            num = num >>> 1; //带着符号右移
        }
        return sb.reverse().toString();
    }
    //直接调用API 把一个10进制数转为32位的2进制数
    public static String getBinaryString(int num){
        return Integer.toBinaryString(num);
        //
        //numberOfLeadingZeros  判断高位几个0 ，二分法 https://www.jianshu.com/p/2c1be41f6e59
    }
}
