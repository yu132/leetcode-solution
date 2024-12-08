package redo.p3000_3099;

public class P3090 {

    class Solution {
        public int maximumLengthSubstring(String s) {
            int ans = 2;
            int[] count = new int[26];
            for (int l = 0, r = 0; r < s.length(); ) {
                if (count[s.charAt(r) - 'a'] == 2) {
                    while (s.charAt(l) != s.charAt(r)) {
                        --count[s.charAt(l) - 'a'];
                        ++l;
                    }
                    ++l;
                } else {
                    ++count[s.charAt(r) - 'a'];
                }
                ++r;
                ans = Math.max(ans, r - l);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        new P3090().new Solution().maximumLengthSubstring("dcfdddccb");
    }

}
