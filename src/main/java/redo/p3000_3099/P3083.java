package redo.p3000_3099;

public class P3083 {

    class Solution {
        public boolean isSubstringPresent(String s) {
            for (int i = 0; i < s.length() - 1; ++i) {
                for (int j = 0; j < s.length() - 1; ++j) {
                    if (s.charAt(i) == s.charAt(j + 1)
                            && s.charAt(i + 1) == s.charAt(j)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

}
