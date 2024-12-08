package redo.p3000_3099;

public class P3019 {

    class Solution {
        public int countKeyChanges(String s) {
            int ans = 0;
            for (int i = 1; i < s.length(); ++i) {
                if (Character.toLowerCase(s.charAt(i - 1)) != Character.toLowerCase(s.charAt(i))) {
                    ++ans;
                }
            }
            return ans;
        }
    }

}
