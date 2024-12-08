package redo.p2600_2699;

public class P2600 {

    class Solution {
        public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
            if (numOnes >= k) {
                return k;
            } else if (numOnes + numZeros >= k) {
                return numOnes;
            } else {
                return numOnes - (k - numOnes - numZeros);
            }
        }
    }

}
