/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dpstudy;

/**
 * 矩阵连乘问题动态规划算法
 *
 * @author zhangwj
 */
public class MatrixMultiply {

    public static void main(String[] args) {
        int[] p = {30, 35, 15, 5, 10, 20, 25};
        int[][] b = new int[p.length - 1][p.length - 1];
        int[][] weights = new int[p.length - 1][p.length - 1];
        System.out.println(getMin(p, weights, b));
        System.out.println(getMatrix(p, 0, 5));
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length; j++) {
                System.out.printf("%-4d", b[i][j]);
            }
            System.out.println("");
        }
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length; j++) {
                System.out.printf("%-6d", i < j ? weights[i][j] : 0);
            }
            System.out.println("");
        }
        track(b, 0, 5);
    }

    public static void track(int[][] b, int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
            return;
        }
        int t = b[i][j];
        System.out.print("(");
        track(b, i, t);
        System.out.print(")(");
        track(b, t + 1, j);
        System.out.print(")");
    }

    public static int getMin(int[] p, int[][] weights, int[][] b) {
        int len = p.length - 1;

        for (int k = 1; k < len; k++) {
            for (int i = len - k - 1; i >= 0; i--) {
                int j = i + k;
                b[i][j] = i;
                weights[i][j] = weights[i][i] + weights[i + 1][j] + p[i] * p[i + 1] * p[j + 1];
                for (int m = i; m < j; m++) {
                    int temp = weights[i][m] + weights[m + 1][j] + p[i] * p[m + 1] * p[j + 1];
                    if (temp < weights[i][j]) {
                        weights[i][j] = temp;
                        b[i][j] = m;
                    }
                }
            }
        }
        return weights[0][len - 1];
    }

    /**
     * 递归的实现
     *
     */
    public static int getMatrix(int[] p, int i, int j) {
        if (i == j) {
            return 0;
        }
        int u = getMatrix(p, i, i) + getMatrix(p, i + 1, j) + p[i] * p[i + 1] * p[j + 1];
        for (int k = i + 1; k < j; k++) {
            int temp = getMatrix(p, i, k) + getMatrix(p, k + 1, j) + p[i] * p[k + 1] * p[j + 1];
            if (temp < u) {
                u = temp;
            }
        }
        return u;
    }
}
