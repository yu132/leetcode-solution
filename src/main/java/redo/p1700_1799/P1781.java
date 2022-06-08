package redo.p1700_1799;

public class P1781 {

    class Solution {
        public int beautySum(String s) {
            int ans = 0;
            int n = s.length();
            int[][] prefixCount26 = prefixCount26(s);
            for (int i = 0; i < n; ++i) {
                for (int j = i + 3; j <= n; ++j) {
                    int max = Integer.MIN_VALUE;
                    int min = Integer.MAX_VALUE;
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        int count = countChar(prefixCount26, ch, i, j);
                        if (count == 0) {
                            continue;
                        }
                        max = Math.max(max, count);
                        min = Math.min(min, count);
                    }
                    ans += max - min;
                }
            }
            return ans;
        }

        int countChar(int[][] prefixCount26, char ch, int start, int end) {
            return prefixCount26[ch - 'a'][end] - prefixCount26[ch - 'a'][start];
        }

        // 用于处理str的计数前缀和
        int[][] prefixCount26(String str) {

            int n = str.length();

            int[][] prefixCount26 = new int[26][n + 1];

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < 26; ++j) {
                    prefixCount26[j][i + 1] = prefixCount26[j][i] + (str.charAt(i) - 'a' == j ? 1 : 0);
                }
            }

            return prefixCount26;
        }
    }

}
