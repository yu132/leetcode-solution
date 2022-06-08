package redo.p1900_1999;

import java.util.HashSet;
import java.util.Set;

public class P1980 {

    class Solution {
        public String findDifferentBinaryString(String[] nums) {
            Set<Long> set = new HashSet<>();
            for (String str : nums) {
                set.add(Long.valueOf(str, 2));
            }
            for (int i = 0; i < 20; ++i) {
                if (!set.contains((long) i)) {
                    return paddingFront(Integer.toString(i, 2), nums.length, '0');
                }
            }
            return "";
        }

        String paddingFront(String str, int len, char padChar) {
            if (str.length() >= len) {
                return str;
            }
            StringBuilder buf = new StringBuilder();
            for (int i = 0; i < len - str.length(); ++i) {
                buf.append(padChar);
            }
            buf.append(str);
            return buf.toString();
        }
    }

}
