package redo.p2100_2199;

public class P2180 {

    class Solution {
        public int countEven(int num) {
            int count = 0;
            for (int i = 2; i <= num; ++i) {
                if (isEvenSum(i)) {
                    ++count;
                }
            }
            return count;
        }

        boolean isEvenSum(int num) {
            int count = 0;
            while (num != 0) {
                count += num % 10;
                num /= 10;
            }
            return count % 2 == 0;
        }
    }

}
