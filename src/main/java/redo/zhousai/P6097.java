package redo.zhousai;

import java.util.HashSet;
import java.util.Set;

public class P6097 {

    class Solution {
        public boolean matchReplacement(String s, String sub, char[][] mappings) {
            Set<String> set = new HashSet<>();

            for (char[] map : mappings) {
                set.add(map[0] + ":" + map[1]);
            }

            outer:
            for (int i = 0; i <= s.length() - sub.length(); ++i) {
                for (int j = 0; j < sub.length(); ++j) {
                    if (s.charAt(i + j) == sub.charAt(j)
                            || set.contains(sub.charAt(j) + ":" + s.charAt(i + j))) {
                        continue;
                    }
                    continue outer;
                }
                return true;
            }

            return false;
        }
    }

}
