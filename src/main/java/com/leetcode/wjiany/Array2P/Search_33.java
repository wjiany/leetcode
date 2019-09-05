package com.leetcode.wjiany.Array2P;

/**
 * 题目要求O（logN）的时间复杂度，基本可以断定本题是需要使用二分查找，怎么分是关键
 * 由于题目说数字了无重复，举个例子
 * 1 2 3 4 5 6 7 可以大致分为两类,
 * 第一类 2 3 4 5 6 7 1这种，也就是nums[start] <= nums[mid]。此例子中就是2 <= 5
 * 这种情况下，前半部分有序。因此如果 nums[start] <=target<nums[mid]。则在前半部分找，
 * 否则去后半部分找。
 * 第二类 6 7 1 2 3 4 5这种，也就是nums[start] > nums[mid]。此例子中就是6 > 2
 * 这种情况下，后半部分有序。因此如果 nums[mid] <target<=nums[end]。则在后半部分找，
 * 否则去前半部分找。
 *
 * 作者：reedfan
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/ji-bai-liao-9983de-javayong-hu-by-reedfan/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class Search_33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = l+(r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target <= nums[r] && target > nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
    /**
     * 暴力 O(n)
     * @param nums
     * @param target
     * @return
     */
    public int search_2(int[] nums, int target) {
        for(int i = 0;i<nums.length;i++){
            if(target == nums[i]){
                return i;
            }
        }
        return -1;
    }
}
