package redo.p3200_3299;

public class P3274 {

    class Solution {
        public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
            return (coordinate1.charAt(0)-'a'+coordinate1.charAt(1)-'0') % 2
                    == (coordinate2.charAt(0)-'a'+coordinate2.charAt(1)-'0') % 2;
        }
    }

}
