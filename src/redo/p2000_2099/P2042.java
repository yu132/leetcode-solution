package redo.p2000_2099;

public class P2042 {

    class Solution {
        public boolean areNumbersAscending(String s) {
            int val = -1, index = 0;
            while (index < s.length()) {
                if ('0' <= s.charAt(index) && s.charAt(index) <= '9') {
                    int x = 0;
                    while (index < s.length() && s.charAt(index) != ' ') {
                        x = x * 10 + s.charAt(index) - '0';
                        ++index;
                    }
                    ++index;
                    if (x <= val) {
                        return false;
                    }
                    val = x;
                }
                ++index;
            }
            return true;
        }
    }

}
