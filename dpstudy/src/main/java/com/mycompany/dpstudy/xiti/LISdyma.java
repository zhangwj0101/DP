package com.mycompany.dpstudy.xiti;

/**
 * Created by zhangwj on 16/3/6.
 */
public class LISdyma {
    public static void main(String[] args) {
        final int NUM = 100;
        int[] nums = new int[NUM];
//        System.out.println(get(nums));
        boolean falg = false;
        int s1 = 0;
        int s2 = 0;
        while (!falg) {
            for (int i = 0; i < NUM; i++) {
                nums[i] = (int) (Math.random() * 1000);
            }
            s1 = get(nums);
            s2 = get1(nums);
            falg = !(s1 == s2);
            System.out.printf("%d,%d\n", s1, s2);
        }

        for (int i = 0; i < NUM; i++) {
            System.out.printf("%4d", nums[i]);
        }
    }

    /**
     * 找出一个有n个数组构成的序列的最长单调递增子序列
     *
     * @param nums
     * @return
     */
    public static int get(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int sum = 1;
        int subsum = 1;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= last) {
                subsum++;
            } else {
                subsum = 1;
                last = nums[i];
            }
            sum = sum > subsum ? sum : subsum;
        }
        return sum;
    }

    public static int get1(int[] nums) {

        int sum = 1;
        int subsum = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            int last = nums[i];
            subsum = 1;
            for (int j = i + 1; j < nums.length && nums[j] >= last; j++, subsum++) ;
            sum = sum > subsum ? sum : subsum;
        }
        return sum;
    }
}
