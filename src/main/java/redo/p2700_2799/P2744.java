package redo.p2700_2799;

import java.util.HashSet;
import java.util.Set;

public class P2744 {

    class Solution {
        public int maximumNumberOfStringPairs(String[] words) {
            Set<String> set = new HashSet<>();
            int ans = 0;
            for (String word : words) {
                String rev = reverse(word);
                if (set.contains(rev)) {
                    ++ans;
                    set.remove(rev);
                } else {
                    set.add(word);
                }

            }
            return ans;
        }

        public String reverse(String str) {
            return new StringBuilder(str).reverse().toString();
        }

    }

}
