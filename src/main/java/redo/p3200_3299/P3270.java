package redo.p3200_3299;

public class P3270 {

    class Solution {
        public int generateKey(int num1, int num2, int num3) {
            int val = 0;
            for (int i = 0; i < 4; ++i) {
                val += (int) (Math.min(num1 % 10, Math.min(num2 % 10, num3 % 10)) * Math.pow(10, i));
                num1 /= 10;
                num2 /= 10;
                num3 /= 10;
            }
            return val;
        }
    }

}
