package com.wjiany.rebuild.datastructure.hash;

import java.util.LinkedList;

/**
 * 自己手动实现Map的底层,Map的底层实现
 * 是由许多链表构成的数组，数组中的元素是链表的
 * 开始节点，通过该节点能找到所有Hash值相同的元素
 */

class MyHashMap {
    LinkedList[] arr = new LinkedList[999];//链表数组
    int size;

    //1.构造方法
    public MyHashMap(){}

    //2.向Map中添加元素
    public void put(Object key, Object value) {
        MyEntry n = new MyEntry(key, value);
        int hash = n.key.hashCode() % arr.length;
        hash = hash<0 ? -hash : hash;
        if(arr[hash] == null) {//如果该位置链表为空
            LinkedList list = new LinkedList();
            arr[hash] = list;
            list.add(n);//将要放入的节点n作为第一个节点放入
        } else {//如果这个位置已经有链表了
            LinkedList list = arr[hash];//取出该处的链表
            //判断有没有键值key重复
            for(int i=0; i<list.size(); i++) {
                MyEntry temp = (MyEntry) list.get(i);
                if(temp.key.equals(key)) {//如果该节点存在，覆盖掉
                    temp.value = value;
                }
            }
            arr[hash].add(n);
        }
    }

    //3.从Map中,用键去取数据
    public Object get(Object key) {
        int hash = key.hashCode() % arr.length;
        hash = hash<0 ? -hash : hash;
        if(arr[hash] != null) {
            LinkedList list = arr[hash];
            for(int i=0; i<list.size(); i++) {
                MyEntry temp = (MyEntry) list.get(i);
                if(temp.key.equals(key)) {
                    return temp.value;
                }
            }
        }

        return null;
    }
}
class MyEntry<K,V>{
    K key;
    V value;
    public  MyEntry(K k,V v) {
        this.key = k;
        this.value = v;
    }
}