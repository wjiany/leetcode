package com.wjiany.leetcode.dp;

class MaxSubArray_53 {

    //贪心算法

    /**
     * 当前元素
     * 当前元素位置的最大和
     * 迄今为止的最大和
     * @param nums
     * @return
     */
        public int maxSubArray_greedy(int[] nums) {
            int n = nums.length;
            int currSum = nums[0], maxSum = nums[0];

            for(int i = 1; i < n; ++i) {
                currSum = Math.max(nums[i], currSum + nums[i]);
                maxSum = Math.max(maxSum, currSum);
            }
            return maxSum;
        }

    /**
     * //leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode/
     * d动态规划
     * @param nums
     * @return
     */
    public int maxSubArray_dp(int[] nums) {
        int n = nums.length, maxSum = nums[0];
        for(int i = 1; i < n; ++i) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }


}