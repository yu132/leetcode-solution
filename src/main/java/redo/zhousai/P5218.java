package redo.zhousai;

public class P5218 {

    class Solution {

        public int minimumNumbers(int num, int k) {
            if (k == 0) {
                if (num % 10 != 0) {
                    return -1;
                } else if (num == 0) {
                    return 0;
                } else {
                    return 1;
                }
            }
            int ans = Integer.MAX_VALUE;
            long base = num % 10;
            if (num != 0 && base == 0) {
                base += 10;
            }
            while (base <= num) {
                if (base % k == 0) {
                    ans = (int) (base / k);
                    break;
                }
                base += 10;
            }
            if (ans == Integer.MAX_VALUE) {
                return -1;
            }
            return ans;
        }

    }

    public static void main(String[] args) {
        new P5218().new Solution().minimumNumbers(20, 1);
    }
}
