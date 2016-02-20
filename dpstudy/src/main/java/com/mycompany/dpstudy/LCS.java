/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dpstudy;

/**
 * 最长公共子序列
 *
 * @author zhangwj
 */
public class LCS {

    public static void main(String[] args) {
        String s1 = "ABCBDABB";
        String s2 = "BDCABA";
        int[][] weights = new int[s1.length()][s2.length()];
        int[][] values = new int[s1.length()][s2.length()];
//        System.out.println(LCS_recursion(s1.toCharArray(), s2.toCharArray(), 0, 0));
        System.out.println(LCS_DP(s1.toCharArray(), s2.toCharArray(), weights, values));

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                System.out.printf("%4d", weights[i][j]);
            }
            System.out.println("");
        }

    }

    /**
     * 递归实现
     *
     * @param s1
     * @param s2
     * @param i
     * @param j
     * @return
     */
    public static int LCS_recursion(char[] s1, char[] s2, int i, int j) {

        if (i >= s1.length || j >= s2.length) {
            return 0;
        }
        if (s1[i] == s2[j]) {
            return 1 + LCS_recursion(s1, s2, i + 1, j + 1);
        } else {
            return Math.max(LCS_recursion(s1, s2, i, j + 1), LCS_recursion(s1, s2, i + 1, j));
        }
    }

    /**
     * 动态规划方法实现
     *
     */
    public static int LCS_DP(char[] s1, char[] s2, int[][] weights, int[][] values) {

        weights[0][0] = s1[0] == s2[0] ? 1 : 0;
        //init
        for (int i = 1; i < s1.length; i++) {
            weights[i][0] = (s1[i] == s2[0]) ? 1 : weights[i - 1][0];
        }
        for (int j = 1; j < s2.length; j++) {
            weights[0][j] = (s1[0] == s2[j]) ? 1 : weights[j - 1][0];
        }

        for (int i = 1; i < s1.length; i++) {
            for (int j = 1; j < s2.length; j++) {
                if (s1[i] == s2[j]) {
                    weights[i][j] = weights[i - 1][j - 1] + 1;
                } else if (weights[i][j - 1] > weights[i - 1][j]) {
                    weights[i][j] = weights[i][j - 1];
                } else {
                    weights[i][j] = weights[i - 1][j];
                }
            }
        }

        return weights[s1.length - 1][s2.length - 1];

    }
}
