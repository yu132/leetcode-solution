package redo.p2400_2499;

public class P2486 {
    class Solution {
        public int appendCharacters(String s, String t) {
            int is = 0, it = 0;
            while (is < s.length() && it < t.length()) {
                if (s.charAt(is) == t.charAt(it)) {
                    ++is;
                    ++it;
                } else {
                    ++is;
                }
            }
            return t.length() - it;
        }
    }
}
