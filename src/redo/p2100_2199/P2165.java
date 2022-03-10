package redo.p2100_2199;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2165 {

    class Solution {
        public long smallestNumber(long num) {
            if (num == 0) {
                return 0;
            }
            boolean neg = false;
            if (num < 0) {
                neg = true;
                num = -num;
            }
            int[] digits = todigits(num);
            Arrays.sort(digits);
            if (neg) {
                long ans = 0;
                for (int i = digits.length - 1; i >= 0; --i) {
                    ans = ans * 10 + digits[i];
                }
                return -ans;
            } else {
                int not0 = 0;
                while (digits[not0] == 0) {
                    ++not0;
                }
                long ans = digits[not0];
                for (int i = 0; i < not0; ++i) {
                    ans *= 10;
                }
                for (int i = not0 + 1; i < digits.length; ++i) {
                    ans = ans * 10 + digits[i];
                }
                return ans;
            }
        }

        int[] todigits(long num) {
            List<Integer> list = new ArrayList<>();
            while (num != 0) {
                list.add((int) (num % 10));
                num /= 10;
            }
            if (list.isEmpty()) {
                list.add(0);
            }
            return list.stream().mapToInt(x -> x).toArray();
        }
    }

}
