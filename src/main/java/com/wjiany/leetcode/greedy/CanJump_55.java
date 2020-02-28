package com.wjiany.leetcode.greedy;

class CanJump_55 {
    /**
     * //leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode/
     *
     * 贪心算法
     * @param nums
     * @return
     */
    public boolean canJump_greedy(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    /**
     *
     * 非官方
     *
     * 就看0之前有没有能跳过他的
     * https://leetcode-cn.com/problems/jump-game/solution/java-ti-jiao-zhong-ji-bai-liao-99981ms-by-huo-le/
     * @param nums
     * @return
     */
        public boolean canJump_find0(int[] nums) {
            if(nums.length==1){
                return true;
            }
            if(nums==null || nums[0]==0){
                return false;
            }
            for(int i = 0; i<nums.length-1; i++){
                if(nums[i]==0){
                    int count = 0;
                    for(int j = i-1; j>=0; j--){
                        if(nums[j] > i-j){
                            break;
                        }else{
                            count++;
                        }
                    }
                    if( count==i){
                        return false;
                    }
                }
            }
            return true;
        }
}