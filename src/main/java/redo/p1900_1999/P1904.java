package redo.p1900_1999;

public class P1904 {

    class Solution {
        public int numberOfRounds(String loginTime, String logoutTime) {
            if (loginTime.compareTo(logoutTime) > 0) {
                return helper(loginTime, "24:00") + helper("00:00", logoutTime);
            } else {
                return helper(loginTime, logoutTime);
            }
        }

        int helper(String loginTime, String logoutTime) {
            int hh1 = Integer.parseInt(loginTime.substring(0, 2)), mm1 = Integer.parseInt(loginTime.substring(3, 5)),
                    hh2 = Integer.parseInt(logoutTime.substring(0, 2)), mm2 = Integer.parseInt(logoutTime.substring(3, 5));
            return Math.max(0, (60 - mm1) / 15 + (hh2 - hh1 - 1) * 4 + mm2 / 15);
        }
    }

}
