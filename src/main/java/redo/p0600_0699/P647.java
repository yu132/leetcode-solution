package redo.p0600_0699;

public class P647 {

    class Solution {
        public int countSubstrings(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); ++i) {
                for (int low = i, high = i; low >= 0 && high < s.length(); --low, ++high) {
                    if (s.charAt(low) == s.charAt(high)) {
                        count += 1;
                    } else {
                        break;
                    }
                }
                for (int low = i, high = i + 1; low >= 0 && high < s.length(); --low, ++high) {
                    if (s.charAt(low) == s.charAt(high)) {
                        count += 1;
                    } else {
                        break;
                    }
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        new P647().new Solution().countSubstrings("fdsklf");
    }


}
