package redo.p1700_1799;

import java.util.function.BiConsumer;

public class P1759 {

    class Solution {

        public final static int MOD = 1_000_000_007;

        public int countHomogenous(String s) {
            int[] ans = new int[1];

            consumeSameCharSubStr(s, (l, h) -> ans[0] = add(ans[0], (long) (h - l + 1) * (h - l) / 2, MOD));

            return ans[0];
        }

        int add(long a, long b, int mod) {
            return (int) ((a % mod + b % mod) % mod);
        }

        //消费字符串中包含完全相同字符的字串的开始和结尾
        void consumeSameCharSubStr(String s, BiConsumer<Integer, Integer> biConsumer) {
            for (int index = 0; index < s.length(); ) {
                int next = indexOfNot(s, index);
                biConsumer.accept(index, next);
                index = next;
            }
        }

        //寻找从start开始的第一个和start不相同的字符，如果后面都相同，则返回-1
        int indexOfNot(String s, int start) {
            for (int i = start + 1; i < s.length(); ++i) {
                if (s.charAt(i) != s.charAt(start)) {
                    return i;
                }
            }
            return s.length();
        }
    }

}
