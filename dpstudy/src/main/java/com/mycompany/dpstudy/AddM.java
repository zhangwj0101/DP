package com.mycompany.dpstudy;

import org.junit.Test;

/**
 * 给定N个整数组成的序列，现在要求将序列分割为M段，每段子序列中的数在原序列中连续排列。如何分割才能使这M段子序列的和的最大值达到最小
 * Created by zwj on 2016/3/20.
 */
public class AddM {

    public int maxAddM(int[] nums, int m) {
        int[][] weights = new int[nums.length + 1][m + 1];
        for (int i = 1; i <= nums.length; i++) {
            weights[i][1] += nums[i - 1];
        }
        for (int j = 2; j <= m; j++) {
            for (int i = j; i <= nums.length; i++) {
                int temp = Integer.MAX_VALUE;
                for (int k = 1; k < i; k++) {
                    int max = Math.max(weights[i][1] - weights[k][1], weights[k][j - 1]);
                    temp = temp > max ? max : temp;
                }
                weights[i][j] = temp;
            }
        }
        return weights[nums.length][m];
    }


    @Test
    public void tes() {
        int[] nums = {10};
        int m = 1;
        System.out.println(maxAddM(nums, m));
    }
}
