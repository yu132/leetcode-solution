package redo.p2000_2099;

public class P2027 {

    class Solution {
        public int minimumMoves(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == 'X') {
                    ++count;
                    i += 2;
                }
            }
            return count;
        }
    }

}
