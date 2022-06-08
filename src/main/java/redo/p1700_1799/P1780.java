package redo.p1700_1799;

public class P1780 {

    class Solution {
        public boolean checkPowersOfThree(int n) {
            return Integer.toString(n, 3).indexOf('2') == -1;
        }
    }

}
