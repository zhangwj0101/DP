package com.mycompany.dpstudy;

/**
 * 矩阵的最大子矩阵和问题
 * <p/>
 * Created by zhangwj on 16/2/28.
 */
public class MaxSubMatrixSum {


    public static void main(String[] args) {
        final int ROW = 3;
        final int COL = 4;
        int[][] matrix = new int[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                int temp = (int) (Math.random() * 10);
                matrix[i][j] = temp > 6 ? -temp : temp;
                System.out.printf("%-4d", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println(new MaxSubMatrixSum().getSubMatrix(matrix));

    }

    public int subColSum(int[] nums) {
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

    /**
     * 矩阵的最大子矩阵和问题
     *
     * @param matrix
     * @return
     */
    public int getSubMatrix(int[][] matrix) {

        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] b = new int[matrix[0].length];
            for (int j = i; j < matrix.length; j++) {
                for (int k = 0; k < b.length; k++) {
                    b[k] += matrix[j][k];
                }
                int subsum = subColSum(b);
                sum = sum > subsum ? sum : subsum;
            }
        }
        return sum;


    }

}
