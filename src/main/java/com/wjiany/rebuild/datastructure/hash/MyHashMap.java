package com.wjiany.rebuild.datastructure.hash;


import java.util.Iterator;
import java.util.LinkedList;

/**
 * 自己手动实现Map的底层,Map的底层实现
 * 是由许多链表构成的数组，数组中的元素是链表的
 * 开始节点，通过该节点能找到所有Hash值相同的元素
 */

public class MyHashMap<K, V> implements MyMap<K, V> {

    private static float LOAD_FACTOR = 0.75f;
    private static Integer DEFAULT_CAPACITY = 1 << 4;
    LinkedList<MyEntry<K, V>>[] arr;//链表数组
    private int capacity;
    private int size = 0;

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }
    public MyHashMap(int initialCapacity) {
        this.capacity = getCapacitySize(initialCapacity);
        this.arr = new LinkedList[this.capacity];
    }

    public void put(K key, V value) {
        MyEntry<K, V> addNode = new MyEntry(key, value);
        int hash = hashForIndex(addNode.hash);
        if (arr[hash] == null) {
            LinkedList list = new LinkedList();
            arr[hash] = list;
            list.add(addNode);
            size++;
            if (size == (int) (arr.length * LOAD_FACTOR-1)) {
                this.arr = resize(arr);
            }
        } else {
            LinkedList<MyEntry<K, V>> list = arr[hash];
            Iterator<MyEntry<K, V>> iterator = list.iterator();
            while (iterator.hasNext()) {
                MyEntry<K, V> curr = iterator.next();
                if (curr.key.equals(key)) {
                    curr.value = value;
                    return;
                }
            }
            arr[hash].add(addNode);
            size++;
        }
    }

    public V get(K key) {
        int hash = hashForIndex(key);
        if(arr[hash] != null) {
            LinkedList<MyEntry<K, V>> list = arr[hash];
            Iterator<MyEntry<K, V>> iterator = list.iterator();
            while (iterator.hasNext()) {
                MyEntry<K, V> curr = iterator.next();
                if (curr.key.equals(key)) {
                    return curr.value;
                }
            }
        }
        return null;
    }

    public V remove(K key) {
        int hashCode = hashForIndex(key);
        LinkedList<MyEntry<K, V>> list = arr[hashCode];
        if (list == null) {
            return null;
        }
        Iterator<MyEntry<K, V>> iterator = list.iterator();
        while (iterator.hasNext()) {
            MyEntry<K, V> curr = iterator.next();
            if (curr.key.equals(key)) {
                iterator.remove();
                size--;
                return curr.value;
            }
        }
        return null;
    }
    public int size() {
        return this.size;
    }
    /**
     * 只考虑了扩没考虑缩
     * @param oldArr
     * @return
     */
    private LinkedList<MyEntry<K, V>>[] resize(LinkedList<MyEntry<K, V>>[] oldArr) {
        LinkedList<MyEntry<K, V>>[] newArr = new LinkedList[this.capacity << 1];
        this.capacity = this.capacity << 1;
        transfer(oldArr, newArr);
        return newArr;
    }

    private void transfer(LinkedList<MyEntry<K, V>>[] oldArr, LinkedList<MyEntry<K, V>>[] newArr) {
        int oldTableLength = oldArr.length;
        for (int i = 0; i < oldTableLength; i++) {
            LinkedList<MyEntry<K, V>> oldLinkList = oldArr[i];
            if (oldLinkList != null) {
                Iterator<MyEntry<K, V>> iterator = oldLinkList.iterator();
                while (iterator.hasNext()) {
                    MyEntry<K, V> oldCurr = iterator.next();
                    int index = i;
                    int newIndex =  oldCurr.hash + oldTableLength;
                    //我觉得这里既然已经保存了原始正数key 的hash，完全可以使用 hash & this.capacity-1计算位置
                    //Java8中：
                    // 1 如果数组当前链表只有一个元素，则采用 hash & this.capacity-1 计算位置
                    // 2 否则采用(myEntry.hash & oldCapacity) != 0 判断是当前位置还是当前位置加oldCapacity
                    //2 Java8中是自己维护链表不是用linkedList，2中进行转移时维护了低位（当前）和高位（当前加oldCapacity）两个尾指针
                    // 这样不用每次计算hash & this.capacity-1，只需要判断(myEntry.hash & oldCapacity) != 0就好了
                    // 最后一次将两个链表赋值到对应数组位置上
                    //总结Java8 是2的情况时，先维护列表，最后放到数组上，而这里都是使用1的情况，直接找到数组，然后往里面加元素
                    if (indexChanged(oldCurr, oldTableLength)) {
                        index = newIndex;
                    }
                    LinkedList<MyEntry<K, V>> newLink = newArr[index];
                    if (newLink == null) {
                        newLink = new LinkedList<>();
                        newLink.add(oldCurr);
                        newArr[index] = newLink;
                    } else {
                        newLink.add(oldCurr);
                    }
                }
            }
        }
    }

    /**
     * 扩容后在原位置还是 oldIndex+oldCapacity 的位置
     * 1 如果落在oldCapacity 之内，则原位置 即，和 oldCapacity & 后不为零
     * 2 如果落在oldCapacity 之外，则位置发生变化，变为oldIndex+oldCapacity
     * --------------省去重新计算hash值----
     * -------------当然，前提是每个MyEntry中增加一个属性hash，这样就计算一次了，这里没有用
     *
     * @param myEntry
     * @param oldCapacity
     * @return
     */
    private boolean indexChanged(MyEntry myEntry, int oldCapacity) {
        return (myEntry.hash & oldCapacity) != 0;//快速取hashCode%capatity
    }
    /**
     * 在arr得length范围内进行hash得映射处理
     *
     * @param key
     * @return
     */
    private int hashForIndex(K key) {
        int hash = key.hashCode();
        return hashForIndex(hash);
    }
    private int hashForIndex(int hash) {
        hash = hash<0 ? -hash : hash;
        return hash & this.capacity-1;//快速取hashCode%capatity
    }
    private int getCapacitySize(int inputCapacity) {
        int n = inputCapacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n == 0 ? 1 : n + 1;
    }
    class MyEntry<K, V> {
        K key;
        V value;
        final int hash;

        public MyEntry(K k, V v) {
            this.key = k;
            this.value = v;
            int code = k.hashCode();
            this.hash = code<0 ? -code : code;
        }
    }
}