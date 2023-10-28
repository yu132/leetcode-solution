package redo.p2500_2599;

public class P2522 {

    class Solution {
        public int minimumPartition(String s, int k) {
            long num = 0;
            int ans = 1;
            for (char ch : s.toCharArray()) {
                long temp = num * 10 + ch - '0';
                if (temp <= k) {
                    num = temp;
                } else if (num == 0 || ch - '0' > k) {
                    return -1;
                } else {
                    ++ans;
                    num = ch - '0';
                }
            }
            return ans;
        }
    }

}
