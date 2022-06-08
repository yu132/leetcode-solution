package redo.p2200_2299;

public class P2224 {

    class Solution {
        public int convertTime(String current, String correct) {
            int hh = Integer.parseInt(correct.substring(0, 2))
                    - Integer.parseInt(current.substring(0, 2));
            int mm = Integer.parseInt(correct.substring(3, 5))
                    - Integer.parseInt(current.substring(3, 5));
            int total = hh * 60 + mm;
            int ans = total / 60;
            total %= 60;
            ans += total / 15;
            total %= 15;
            ans += total / 5;
            total %= 5;
            ans += total;
            return ans;
        }
    }

}
