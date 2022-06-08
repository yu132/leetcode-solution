package redo.p1900_1999;

public class P1945 {

    class Solution {
        public int getLucky(String s, int k) {
            --k;

            int val = 0;

            for (char ch : s.toCharArray()) {
                val += digitsSum(ch - 'a' + 1);
            }

            while (k-- > 0) {
                val = digitsSum(val);
            }

            return val;
        }

        public int digitsSum(int num) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            return sum;
        }
    }

}
