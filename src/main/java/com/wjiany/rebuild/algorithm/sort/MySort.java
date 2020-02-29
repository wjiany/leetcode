package com.wjiany.rebuild.algorithm.sort;

import org.junit.Test;

/**
 * 内部排序 ：
 * 1 冒泡
 * 2 选择
 * 3 插入
 * 4 希尔(增强插入)
 * 5 快速
 * 6 堆排序(选择排序)
 * 7 归并排序
 * 8 基数排序
 */
public class MySort {
    @Test
    public void test(){
        int[] ints = {2,7,-1,3, 2, 1,5,6,7};
        //shellSort(ints);
        //quickSort(ints,0,ints.length-1);
        mergeSort(ints,0,ints.length-1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
    /**
     * 冒泡排序 稳定（相同元素相对顺序依旧保持不变）
     * O = n²
     * O = 1；
     * @param nums
     */
    public void bubbleSort(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 1; j < nums.length -i ; j++) {
                if(nums[j] < nums[j-1]) {
                    swap(nums,j,j-1);
                }
            }

        }
    }

    /**
     * 简单选择排序 不稳定
     * https://www.cnblogs.com/jingmoxukong/p/4303289.html
     * O = n²
     * O = 1；
     * @param nums
     */
    public void selectSort(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            int index = i;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] > nums[j]){
                    index = j;
                }
            }
            if(index != i){
                swap(nums,i,index);
            }
        }
    }
    //每次交换不太好
    @Deprecated
    public void selectSort_low(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] > nums[j]){
                    swap(nums,i,j);
                }

            }
        }
    }

    private void  swap(int[] nums ,int left,int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
    /**
     * 直接插入，推荐方法
     * 自己写的插入，其实是每次当前数字和前面所有的进行比较交换
     * 其实是比较交换  思路差不多 这种更好理解一点
     * @param nums
     */
    public void insertSort_swap(int[] nums){
        for (int i = 1; i < nums.length ; i++) {  //记录次数
            for (int j = i; j > 0; j--) {  //前面已经排序，避免无效交换，内部循环倒序
                if(nums[j] < nums[j-1]){
                    swap(nums,j-1,j);
                }
            }
        }
    }
    /**
     *
     * 直接插入排序
     * https://www.cnblogs.com/jingmoxukong/p/4303270.html
     * O(N2) O（1） 稳定
     * 内层循环已经排序的，外层循环没有排序的，往前面排序的一个个比较插入,
     * 其实是比较移动
     * @param nums
     */
    public void insertSort_move(int[] nums){
        for (int i = 1; i < nums.length ; i++) {
            // 因为前i-1个数都是从小到大的有序序列，
            // 所以只要当前比较的数tmp比(list[j])小，就把这个数后移一位
            int tmp = nums[i];
            int j = 0;
            for ( j = i - 1; j >= 0 &&tmp < nums[j]; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j+1] = tmp;
        }
    }

    /**
     * 自己写的插入，每次都是一个小的选择排序，选择小的排在前面
     * 其实是比较交换  思路差不多 这种更好理解一点
     * @param nums
     */
    public void insertSort_select(int[] nums){
        for (int i = 1; i < nums.length ; i++) {
            for (int j = 0; j < i; j++) {  //内部正序
                if(nums[j] > nums[i]){
                    swap(nums,i,j);
                }
            }
        }
    }

    /**
     * 希尔排序  一种插入排序  但是间隔大时候移动少，间隔小时候移动短，所以效率更高
     * O(Nlog2N) O(1)  不稳定
     * 每次对间隔为gap的元素进行插入排序
     * https://www.cnblogs.com/jingmoxukong/p/4303279.html
     * @param nums
     */
    public void shellSort(int[] nums) {
        int gap = nums.length/2;
        for (; gap > 0 ; gap /=2) {
            // 把距离为 gap 的元素编为一个组，扫描所有组
            //外循环包含两层意思，一个对0开始的间隔gap进行循环，一个是对0-gap间的所有条战线的循环
            // 两个循环合起来就是gap-nums.length
            for (int i = gap; i < nums.length; i++) {
                // 对距离为 gap 的元素组进行排序
                for (int j = i; j >gap-1 && nums[j-gap] > nums[j]; j = j - gap) {
                    swap(nums,j,j-gap);
                }
            }
        }
    }

    /**
     * 快排  不稳定
     * https://www.cnblogs.com/jingmoxukong/p/4302891.html
     * O(Nlog2N)    O(Nlog2N)
     * @param nums
     */
    public void quickSort(int[] nums,int left,int right) {
      if(left < right){
        int partation = partation(nums, left, right);
        quickSort(nums,left,partation-1);
        quickSort(nums,partation+1,right);
      }
    }

    /**
     * 返回新的中间基准
     *
     * 记录base值，（nums[left]）
     * 从右向左找比base值小的，找到了放在左上
     * 从左向右找比base值大的，找到了放在右上
     * 在left<right 范围内重复上面步骤，完成了一轮 左边小于base，右边大于base
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partation(int[] nums, int left,int right){
        int baseValue = nums[left];
        while (left < right){
            while (left < right && nums[right]>=baseValue) right--;
            nums[left] = nums[right];
            while (left < right && nums[left]<=baseValue) left++;
            nums[right] = nums[left];
        }
        nums[left] = baseValue;
        return left;
    }

    /**
     * 堆排序 O(nlog2n) O(1) 不稳定
     * https://www.cnblogs.com/jingmoxukong/p/4303826.html
     * @param nums
     */
    public void heapSort(int[] nums) {
        for (int i = nums.length / 2; i >= 0; i--) { // 循环建立初始堆，此时所有的父 大于 子
            heapAdjust(nums, i, nums.length);
        }
        for (int i = nums.length - 1; i > 0; i--) { // 进行n-1次循环，完成排序
            swap(nums,0,i);                    // 最后一个元素和第一元素进行交换
            heapAdjust(nums, 0, i);         // 筛选 R[0] 结点，得到i-1个结点的堆
        }
    }

    /**
     * 将parent 保证为以下子树的最大值，同时循环下去，
     * 最终保证的叶子节点的父节点比叶子节点大，所以要从最叶子的父节点开始使用此方法
     * @param array
     * @param parent
     * @param length
     */
    private void heapAdjust(int[] array, int parent, int length) {
        int temp = array[parent]; // temp保存当前父节点
        int child = 2 * parent + 1; // 先获得左孩子
        while (child < length) {
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (child + 1 < length && array[child] < array[child + 1]) {
                child++;
            }
            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= array[child])
                break;
            // 把孩子结点的值赋给父结点
            array[parent] = array[child];
            // 选取孩子结点的左孩子结点,继续向下筛选
            parent = child;
            child = 2 * child + 1;
        }
        array[parent] = temp;
    }

    /**
     * 归并排序
     * https://www.cnblogs.com/jingmoxukong/p/4308823.html
     * O(nlog2n) O(n) 稳定
     * @param nums
     * @param left
     * @param right
     */
    public void mergeSort(int[] nums,int left ,int right){
        if(left < right){ //相等说明有一个元素 ，一个元素就停止
            int mid = left + (right-left)/2;
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);
            merger(nums,left,mid,right);
        }

    }
    /**
     * 将nums的left-mid  和mid+1 - right 归并
     * @param nums
     * @param left
     * @param mid
     * @param right
     */
    private void merger(int[] nums,int left ,int mid ,int right){
        int[] tmpInts = new int[nums.length];
        int p1 = left;
        int p2 = mid+1;
        int tmpPoint = left;
        while (p1<=mid && p2<=right){
            if(nums[p1] < nums[p2]){
                tmpInts[tmpPoint++] = nums[p1++];
            }else {
                tmpInts[tmpPoint++] = nums[p2++];
            }
        }
        while (p1 <= mid){
            tmpInts[tmpPoint++] = nums[p1++];
        }
        while (p2 <= right){
            tmpInts[tmpPoint++] = nums[p2++];
        }
        for (int i = left; i <= right; i++) {
            nums[i] = tmpInts[i];
        }
    }

    /**
     * **基数排序 n个数字  这里是只能正数，如果负数可以增加桶
     * https://www.cnblogs.com/luomeng/p/10639926.html
     * * ---O(d(n+r))     r为基数（桶数），d为位数
     * * ---n+r     对于任何位数上的基数进行“装桶”操作时，都需要n+r个临时空间。
     * -----稳定
     * 当然也可使使用数组加链表来保存不同桶的数据，链表为桶，但是空间复杂度变大
     */
    public void radixSort(int[] nums){
        //待排序列最大值
        int max =getMax(nums);
        int radix;//指数
        //从个位开始，对数组进行排序
        for (radix = 1; max / radix > 0; radix *= 10) {
            //存储待排元素的临时数组
            int[] tmpInts = new int[nums.length];
            //分桶 应该也可以用数据加链表，链表直接存取数据，到时候一次取出即可
            // 1,存放时记录次数，
            // 2 ，根据次数记录当前桶中待排序数字取出时索引右边界（值-1）（数组加链表不需要这个）
            int[] buckets = new int[10];
            for (int value : nums) {
                buckets[getDigit(value,radix)]++;  //(value / exp) % 10 :value的最底位(个位)
            }
            for (int i = 1; i < 10; i++) {
                buckets[i] += buckets[i - 1];
            }
            //将数据按当前 的 位 排序 存储到临时数组tmp中
            // 这里要从右向左扫描，保证排序稳定性
            //每个桶 从有边界向左添加数据
            for (int i = nums.length - 1; i >= 0; i--) {
                tmpInts[buckets[getDigit(nums[i],radix)] - 1] = nums[i];
                buckets[getDigit(nums[i],radix)]--;
            }
            //将有序元素temp赋给nums
            System.arraycopy(tmpInts, 0, nums, 0, nums.length);
        }

    }

    /**
     *
     * @param num  数字
     * @param radix  基数，用于决定取个位，十位，百位..比如1，10 ，100..
     * @return
     */
    private int getDigit(int num ,int radix){
        return num/radix%10;
    }
    private int getMax(int[] nums){
        int max = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    @Test
    public void test1(){
        int[] ints = {2,7,-1,3, 2, 1,5,6,7};
        int[] arr = { 49, 38, 65, 97, 76, 13, 27, 50 };
        radixSort(arr);
        System.out.println("排好序的数组：");
        for (int e : arr)
            System.out.print(e+" ");
    }
}
