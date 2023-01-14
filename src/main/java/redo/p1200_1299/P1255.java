package redo.p1200_1299;

import java.util.ArrayList;
import java.util.List;

public class P1255 {

    class Solution {

        int max = 0;

        public int maxScoreWords(String[] words, char[] letters, int[] score) {
            int[] count = new int[26];

            for (char ch : letters) {
                ++count[ch - 'a'];
            }

            int[] points = new int[words.length];
            int[][] wordsCount = new int[words.length][];
            for (int i = 0; i < words.length; ++i) {
                wordsCount[i] = countLowercaseLetters(words[i]);
                for (int j = 0; j < 26; ++j) {
                    points[i] += score[j] * wordsCount[i][j];
                }
            }

            List<Integer> available = new ArrayList<>();

            for (int i = 0; i < words.length; ++i) {
                if (greaterEquals(count, wordsCount[i])) {
                    available.add(i);
                }
            }

            backtrack(0, count, 0, available, wordsCount, points);

            return max;
        }

        void backtrack(int index, int[] count, int point, List<Integer> available, int[][] wordsCount, int[] points) {
            if (index == available.size()) {
                max = Math.max(max, point);
                return;
            }
            int[] wordCount = wordsCount[available.get(index)];
            backtrack(index + 1, count, point, available, wordsCount, points);
            if (greaterEquals(count, wordCount)) {
                minus(count, wordCount);
                backtrack(index + 1, count, point + points[available.get(index)], available, wordsCount, points);
                add(count, wordCount);
            }
        }


        //长度相等的数组，每个位置上相加
        void add(int[] arr1, int[] arr2) {
            for (int i = 0; i < arr1.length; ++i) {
                arr1[i] += arr2[i];
            }
        }

        //长度相等的数组，每个位置上相减
        void minus(int[] arr1, int[] arr2) {
            for (int i = 0; i < arr1.length; ++i) {
                arr1[i] -= arr2[i];
            }
        }

        //长度相等的数组，返回前一个数组是否比后一个数组的每个位置的元素都大或相等
        boolean greaterEquals(int[] arr1, int[] arr2) {
            for (int i = 0; i < arr1.length; ++i) {
                if (arr1[i] < arr2[i]) {
                    return false;
                }
            }
            return true;
        }

        //str中必须仅包含小写字符，计算每个小写字符的数量
        public int[] countLowercaseLetters(String str) {
            int[] count = new int[26];
            for (char ch : str.toCharArray()) {
                ++count[ch - 'a'];
            }
            return count;
        }
    }

}
