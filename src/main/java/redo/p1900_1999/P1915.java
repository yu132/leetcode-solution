package redo.p1900_1999;

public class P1915 {

    class Solution {
        public long wonderfulSubstrings(String word) {
            long[] hash = new long[1 << 10];
            hash[0] = 1;

            int mask = 0;
            long ans = 0;

            for (int i = 0; i < word.length(); ++i) {
                mask ^= 1 << (word.charAt(i) - 'a');
                ans += hash[mask];
                for (int j = 0; j < 10; ++j) {
                    ans += hash[mask ^ (1 << j)];
                }
                ++hash[mask];
            }
            return ans;
        }
    }

}
