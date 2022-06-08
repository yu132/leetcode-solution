package redo.p1700_1799;

import java.util.Arrays;
import java.util.HashSet;

public class P1733 {

    class Solution {
        public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
            for (int[] language : languages) {
                Arrays.sort(language);
            }
            HashSet<Integer> visited = new HashSet<>();
            int[] countN = new int[n + 1];
            int count = 0;
            for (int[] friendship : friendships) {
                int a = friendship[0] - 1, b = friendship[1] - 1;
                if (findEquals(languages[a], languages[b])) {
                    continue;
                }
                if (!visited.contains(a)) {
                    visited.add(a);
                    for (int val : languages[a]) {
                        ++countN[val];
                    }
                    ++count;
                }
                if (!visited.contains(b)) {
                    visited.add(b);
                    for (int val : languages[b]) {
                        ++countN[val];
                    }
                    ++count;
                }
            }
            int max = max(countN);
            return count - max;
        }

        public int max(int... nums) {
            int max = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                max = Math.max(max, nums[i]);
            }
            return max;
        }

        //排序查找两个数组是否包含相同元素
        boolean findEquals(int[] sortedArr1, int[] sortedArr2) {
            int index1 = 0, index2 = 0;
            while (index1 < sortedArr1.length && index2 < sortedArr2.length) {
                if (sortedArr1[index1] < sortedArr2[index2]) {
                    ++index1;
                } else if (sortedArr1[index1] > sortedArr2[index2]) {
                    ++index2;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

}
