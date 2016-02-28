package com.mycompany.dpstudy;

/**
 * 计算最大子段和的方法
 * <p/>
 * Created by zhangwj on 16/2/28.
 */
public class MaxSubSum {
    public static void main(String[] args) {
        int[] nums = {-2, 11, -4, 13, -5, -2};
        MaxSubSum test = new MaxSubSum();

        System.out.println(test.subSum0(nums));
    }

    public int get(int[] nums, int left, int right) {

        if (left == right) {
            return nums[right] > 0 ? nums[right] : 0;
        }
        int mid = (left + right) / 2;
        int sumleft = get(nums, left, mid);
        int sumright = get(nums, mid + 1, right);
        int s1 = 0;
        int subs1 = 0;
        for (int i = mid; i >= left; i--) {
            subs1 += nums[i];
            s1 = s1 < subs1 ? subs1 : s1;
        }
        int s2 = 0;
        int subs2 = 0;
        for (int i = mid + 1; i <= right; i++) {
            subs2 += nums[i];
            s2 = s2 > subs2 ? s2 : subs2;
        }
        int sum = s1 + s2;
        sum = sum > sumleft ? sum : sumleft;
        sum = sum > sumright ? sum : sumright;
        return sum;
    }


    /**
     * 最常规的办法解决
     *
     * @param nums
     * @return
     */
    public int subSum0(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int subsum = 0;
            for (int j = i; j < nums.length; j++) {
                subsum += nums[j];
                sum = sum > subsum ? sum : subsum;
            }
        }
        return sum;
    }


    /**
     * 分治的思想解决
     *
     * @param nums
     * @return
     */
    public int subSum1(int[] nums) {
        return get(nums, 0, nums.length - 1);
    }

    /**
     * 动态规划的思想解决
     *
     * @param nums
     * @return
     */
    public int subSum2(int[] nums) {
        int sum = 0;
        int subsum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (subsum > 0) {
                subsum += nums[i];
            } else {
                subsum = nums[i];
            }
            sum = sum > subsum ? sum : subsum;
        }
        return sum;
    }

}
