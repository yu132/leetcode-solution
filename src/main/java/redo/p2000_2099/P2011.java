package redo.p2000_2099;

public class P2011 {

    class Solution {
        public int finalValueAfterOperations(String[] operations) {
            int val = 0;

            for (String op : operations) {
                if ("++X".equals(op) || "X++".equals(op)) {
                    ++val;
                } else {
                    --val;
                }
            }

            return val;
        }
    }

}
