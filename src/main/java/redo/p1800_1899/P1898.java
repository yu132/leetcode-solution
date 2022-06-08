package redo.p1800_1899;

import java.util.HashSet;
import java.util.function.Function;

public class P1898 {

    class Solution {
        public int maximumRemovals(String s, String p, int[] removable) {
            return binarySearchMax(0, removable.length, mid -> {
                String str = get(s, removable, mid);
                return isSubSeq(str, p);
            }) + 1;
        }

        // remove include end
        String get(String s, int[] removable, int end) {
            HashSet<Integer> set = new HashSet<>(end);
            for (int i = 0; i <= end; ++i) {
                set.add(removable[i]);
            }
            StringBuilder buf = new StringBuilder(s.length() - end);
            for (int i = 0; i < s.length(); ++i) {
                if (!set.contains(i)) {
                    buf.append(s.charAt(i));
                }
            }
            return buf.toString();
        }

        boolean isSubSeq(String a, String b) {
            if (b.length() > a.length()) {
                return false;
            }
            for (int indexA = -1, indexB = 0; indexB < b.length(); ++indexB) {
                if ((indexA = a.indexOf(b.charAt(indexB), indexA + 1)) == -1) {
                    return false;
                }
            }
            return true;
        }

        public int binarySearchMax(int low, int high, Function<Integer, Boolean> judge) {
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (judge.apply(mid)) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low - 1;
        }

    }

}
