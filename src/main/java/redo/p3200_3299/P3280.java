package redo.p3200_3299;

public class P3280 {

    class Solution {
        public String convertDateToBinary(String date) {
            String[] val = date.split("-");
            for (int i = 0; i < val.length; ++i) {
                val[i] = String.valueOf(Integer.toBinaryString(Integer.parseInt(val[i])));
            }
            return String.join("-", val);
        }
    }

}
