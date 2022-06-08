package redo.p2200_2299;

public class P2278 {

    class Solution {
        public int percentageLetter(String s, char letter) {
            int count = 0;
            for (char ch : s.toCharArray()) {
                if (ch == letter) {
                    ++count;
                }
            }
            return (int) ((double) count / s.length() * 100);
        }
    }

}
