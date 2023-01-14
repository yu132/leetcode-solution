package redo.p2500_2599;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P2520 {

    class Solution {
        public int countDigits(int num) {
            Integer[] digits = toDigits(num);
            int ans = 0;
            for (int i = 0; i < digits.length; ++i) {
                if (num % digits[i] == 0) {
                    ++ans;
                }
            }
            return ans;
        }

        Integer[] toDigits(int num) {
            List<Integer> list = new ArrayList<>();
            while (num != 0) {
                list.add(num % 10);
                num /= 10;
            }
            Collections.reverse(list);
            if (list.isEmpty()) {
                list.add(0);
            }
            return list.toArray(new Integer[0]);
        }
    }

}
