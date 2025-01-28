package redo.p2700_2799;

public class P2748 {

    class Solution {
        public int countBeautifulPairs(int[] nums) {
            int ans = 0;
            for (int i = 0; i < nums.length; ++i) {
                for (int j = i + 1; j < nums.length; ++j) {
                    int f = first(nums[i]);
                    int l = nums[j] % 10;
                    if (gcd(f, l) == 1) {
                        ++ans;
                    }
                }
            }
            return ans;
        }

        int first(int num) {
            int temp = 0;
            while (num != 0) {
                temp = num % 10;
                num /= 10;
            }
            return temp;
        }

        /**
         * 求两个数的最小公约数
         *
         * @param m 不能为0
         * @param n 可为0
         * @return
         */
        public int gcd(int m, int n) {
            int r;
            while (n > 0) {
                r = m % n;
                m = n;
                n = r;
            }
            return m;
        }

    }

}
