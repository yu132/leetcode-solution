package redo.p2100_2199;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2160 {

    class Solution {
        public int minimumSum(int num) {
            int[] digits = todigits(num);
            Arrays.sort(digits);
            int base = 1, ans = 0;
            for (int i = digits.length - 1; i >= 0; i -= 2) {
                ans += digits[i] * base;
                if (i - 1 >= 0) {
                    ans += digits[i - 1] * base;
                }
                base *= 10;
            }
            return ans;
        }

        int[] todigits(int num) {
            List<Integer> list = new ArrayList<>();
            while (num != 0) {
                list.add(num % 10);
                num /= 10;
            }
            if (list.isEmpty()) {
                list.add(0);
            }
            return list.stream().mapToInt(x -> x).toArray();
        }
    }

}
