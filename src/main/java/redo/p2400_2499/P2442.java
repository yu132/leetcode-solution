package redo.p2400_2499;

import java.util.HashSet;
import java.util.Set;

public class P2442 {

    class Solution {
        public int countDistinctIntegers(int[] nums) {
            Set<Long> set = new HashSet<>();
            for (int num : nums) {
                if (!set.contains(num)) {
                    set.add((long) num);
                    set.add(reverse(num));
                }
            }
            return set.size();
        }

        public long reverse(int num) {
            int rev = 0;
            while (num != 0) {
                rev = rev * 10 + num % 10;
                num /= 10;
            }
            return rev;
        }
    }

}
