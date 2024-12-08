package redo.p3000_3099;

public class P3079 {

    class Solution {
        public int sumOfEncryptedInt(int[] nums) {
            int ans = 0;
            for (int num : nums) {
                int digit = 0;
                int max = 0;
                while (num > 0) {
                    ++digit;
                    max = Math.max(max, num % 10);
                    num /= 10;
                }
                for (int i = 0; i < digit; ++i) {
                    ans += max;
                    max *= 10;
                }
            }
            return ans;
        }
    }

}
