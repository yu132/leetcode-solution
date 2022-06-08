package redo.LCP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LCP40 {

    class Solution {
        public int maxmiumScore(int[] cards, int cnt) {

            List<Integer> odd = new ArrayList<>(),
                    even = new ArrayList<>();

            for (int num : cards) {
                if (num % 2 == 0) {
                    even.add(num);
                } else {
                    odd.add(num);
                }
            }

            Collections.sort(odd);
            Collections.sort(even);

            int ans = 0;

            int index1 = odd.size() - 1, index2 = even.size() - 1;

            if (cnt % 2 == 1) {
                if (even.size() == 0) {
                    return 0;
                }
                ans += even.get(index2--);
                --cnt;
            }

            while (cnt > 0) {
                int maxOdd = -1, maxEven = -1;
                if (index1 >= 1) {
                    maxOdd = odd.get(index1) + odd.get(index1 - 1);
                }
                if (index2 >= 1) {
                    maxEven = even.get(index2) + even.get(index2 - 1);
                }
                if (maxOdd == -1 && maxEven == -1) {
                    return 0;
                }
                if (maxOdd >= maxEven) {
                    ans += maxOdd;
                    index1 -= 2;
                } else {
                    ans += maxEven;
                    index2 -= 2;
                }
                cnt -= 2;
            }

            return ans;
        }
    }

}
