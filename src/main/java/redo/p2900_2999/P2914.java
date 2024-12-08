package redo.p2900_2999;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

public class P2914 {

    class Solution {
        public int minChanges(String s) {
            AtomicInteger ans = new AtomicInteger(0);
            AtomicBoolean flag = new AtomicBoolean(false);
            consumeSameCharSubStr(s, (i, j) -> {
                int len = j - i + (flag.get() ? 1 : 0);
                if (flag.get()) {
                    ans.addAndGet(1);
                }
                flag.set(len % 2 != 0);

            });
            if (flag.get()) {
                ans.addAndGet(1);
            }
            return ans.get();
        }

        //消费字符串中包含完全相同字符的字串的开始和结尾
        void consumeSameCharSubStr(String s, BiConsumer<Integer, Integer> biConsumer) {
            for (int index = 0; index < s.length(); ) {
                int next = indexOfNot(s, index);
                biConsumer.accept(index, next);
                index = next;
            }
        }

        //寻找从start开始的第一个和start不相同的字符，如果后面都相同，则返回s.length()
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
