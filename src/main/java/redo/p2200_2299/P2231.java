package redo.p2200_2299;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P2231 {

    class Solution {
        public int largestInteger(int num) {
            if (num == 0) {
                return 0;
            }
            List<Boolean> isOdd = new ArrayList<>();
            List<Integer> odd = new ArrayList<>(), even = new ArrayList<>();
            while (num > 0) {
                int digit = num % 10;
                num /= 10;
                if (digit % 2 == 1) {
                    odd.add(digit);
                    isOdd.add(true);
                } else {
                    even.add(digit);
                    isOdd.add(false);
                }
            }

            Collections.sort(odd);
            Collections.sort(even);

            int ans = 0, base = 1;
            for (int i = 0, i1 = 0, i2 = 0; i < isOdd.size(); ++i) {
                if (isOdd.get(i)) {
                    ans += base * odd.get(i1++);
                } else {
                    ans += base * even.get(i2++);
                }
                base *= 10;
            }
            return ans;
        }
    }

}
