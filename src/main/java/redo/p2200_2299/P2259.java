package redo.p2200_2299;

public class P2259 {

    class Solution {
        public String removeDigit(String number, char digit) {
            int index = 0, lastIndex = -1;
            while ((index = number.indexOf(digit, lastIndex + 1)) != -1) {
                lastIndex = index;
                if (index + 1 < number.length()) {
                    if (number.charAt(index + 1) > digit) {
                        break;
                    }
                }
            }
            return new StringBuilder(number).deleteCharAt(lastIndex).toString();
        }
    }

}
