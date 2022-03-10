package redo.p2100_2199;

import java.util.HashSet;
import java.util.Set;

public class P2135 {

    class Solution {
        public int wordCount(String[] startWords, String[] targetWords) {
            Set<Integer> set = new HashSet<>();

            for (String str : startWords) {
                set.add(toBin(str));
            }

            int ans = 0;

            for (String str : targetWords) {
                int bin = toBin(str);
                for (int i = 0; i < 26; ++i) {
                    if ((bin | (1 << i)) == bin) {
                        if (set.contains(bin & (~(1 << i)))) {
                            ++ans;
                            break;
                        }
                    }
                }
            }

            return ans;
        }

        int toBin(String str) {
            int val = 0;
            for (char ch : str.toCharArray()) {
                val |= 1 << ch - 'a';
            }
            return val;
        }
    }

}
