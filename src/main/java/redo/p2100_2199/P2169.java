package redo.p2100_2199;

public class P2169 {

    class Solution {
        public int countOperations(int num1, int num2) {
            int c, count = 0;
            while (num1 != 0 && num2 != 0) {
                count += num1 / num2;
                c = num1 % num2;
                num1 = num2;
                num2 = c;
            }
            return count;
        }
    }

}
