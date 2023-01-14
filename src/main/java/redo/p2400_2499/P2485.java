package redo.p2400_2499;

public class P2485 {

    class Solution {
        public int pivotInteger(int n) {
            int sum = n * (n + 1) / 2, nowSum = 0;
            for (int i = 1; i <= n; ++i) {
                if (sum - nowSum - i == nowSum) {
                    return i;
                }
                nowSum += i;
            }
            return -1;
        }
    }


}
