package redo.p2500_2599;

public class P2546 {

    class Solution {
        public boolean makeStringsEqual(String s, String target) {
            if (s.equals(target)) {
                return true;
            }
            return !(full0(s) || full0(target));
        }

        boolean full0(String str) {
            for (char ch : str.toCharArray()) {
                if (ch != '0') {
                    return false;
                }
            }
            return true;
        }
    }

}
