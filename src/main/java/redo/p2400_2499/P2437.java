package redo.p2400_2499;

public class P2437 {

    class Solution {
        public int countTime(String time) {
            int hh;
            if (time.charAt(0) == '?' && time.charAt(1) == '?') {
                hh = 24;
            } else if (time.charAt(0) == '?') {
                if (time.charAt(1) >= '4') {
                    hh = 2;
                } else {
                    hh = 3;
                }
            } else if (time.charAt(1) == '?') {
                if (time.charAt(0) == '2') {
                    hh = 4;
                } else {
                    hh = 10;
                }
            } else {
                hh = 1;
            }
            int mm;
            if (time.charAt(3) == '?' && time.charAt(4) == '?') {
                mm = 60;
            } else if (time.charAt(3) == '?') {
                mm = 6;
            } else if (time.charAt(4) == '?') {
                mm = 10;
            } else {
                mm = 1;
            }
            return hh * mm;
        }
    }

}
