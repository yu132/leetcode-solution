package redo.p2100_2199;

public class P2116 {

    class Solution {
        public boolean canBeValid(String s, String locked) {
            if (s.length() % 2 != 0) {
                return false;
            }
            int x = 0;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '(' || locked.charAt(i) == '0') {
                    ++x;
                } else {
                    --x;
                }
                if (x < 0) {
                    return false;
                }
            }
            x = 0;
            for (int i = s.length() - 1; i >= 0; --i) {
                if (s.charAt(i) == ')' || locked.charAt(i) == '0') {
                    ++x;
                } else {
                    --x;
                }
                if (x < 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
