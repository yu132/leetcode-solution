package redo.p1700_1799;

public class P1737 {

    class Solution {
        public int minCharacters(String a, String b) {
            return min(helper1(a, b), helper1(b, a), helper2(a) + helper2(b));
        }


        int helper1(String a, String b) {
            int[] countA = countLowercaseLetters(a), countB = countLowercaseLetters(b);
            int la = a.length(), pb = 0, ans = Integer.MAX_VALUE;
            for (int i = 0; i < 25; ++i) {
                la -= countA[i];
                pb += countB[i];
                ans = Math.min(la + pb, ans);
            }
            return ans;
        }

        int helper2(String a) {
            int[] count = countLowercaseLetters(a);
            int max = max(count);
            return a.length() - max;
        }

        public int min(int... nums) {
            int min = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                min = Math.min(min, nums[i]);
            }
            return min;
        }

        public int max(int... nums) {
            int max = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                max = Math.max(max, nums[i]);
            }
            return max;
        }

        public int[] countLowercaseLetters(String str) {
            int[] count = new int[26];
            for (char ch : str.toCharArray()) {
                ++count[ch - 'a'];
            }
            return count;
        }
    }

}
