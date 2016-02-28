package com.mycompany.dpstudy;

/**
 * 最大m子段和问题
 * <p/>
 * Created by zhangwj on 16/2/28.
 */
public class Max_MSubSum {
    public static void main(String[] args) {
        int[] nums = {-2, 11, -4, 13, -5, -2};
        Max_MSubSum test = new Max_MSubSum();
        int m = 2;
        System.out.println(test.mSubSum(nums, m));
    }

    /**
     * 动态规划的思想解决
     *
     * @param nums
     * @return
     */
    public int mSubSum(int[] nums, int m) {
        int sum = 0;
        int[][] b = new int[m + 1][nums.length];
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= nums.length - m + i - 1; j++) {
                b[i][j] = b[i][j - 1] + nums[j - 1];
                for (int k = i - 1; k < j; k++) {
                    b[i][j] = b[i][j] < b[i - 1][k] + nums[j - 1] ? b[i][k] + nums[j - 1] : b[i][j];
                }
            }
        }
        for (int j = m; j < nums.length; j++) {
            sum = sum < b[m][j] ? b[m][j] : sum;
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.printf("%-4d", b[i][j]);
            }
            System.out.println();
        }
        return sum;
    }

    public int mSubSum1(int[] nums, int m) {
        int sum = 0;
        int[][] b = new int[m][nums.length];
        for (int i = 0; i < m; i++) {
            b[i][i] = nums[i];
            for (int j = i; j <= nums.length - m + i; j++) {
                if (j > i) {
                    b[i][j] = b[i][j - 1] + nums[j];
                    for (int k = i - 1; k >= 0 && k < j; k++) {
                        b[i][j] = b[i][j] < b[i - 1][k] + nums[j] ? b[i][k] + nums[j] : b[i][j];
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.printf("%-4d", b[i][j]);
            }
            System.out.println();
        }
        for (int i = m - 1; i < nums.length; i++) {
            sum = sum > b[m - 1][i] ? sum : b[m - 1][i];
        }
        return sum;
    }

}
