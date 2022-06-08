/**
 * @Title: _792.java
 *
 * @Package _0700_0799
 *
 * @Description: TODO(用一句话描述该文件做什么)
 *
 * @author 余定邦
 *
 * @date 2020年1月30日
 *
 */
package _0700_0799;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: _792
 *
 * @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author 余定邦
 *
 * @date 2020年1月30日
 * 
 */
public class _792 {

    class Solution {
        public int numMatchingSubseq(String S, String[] words) {
            @SuppressWarnings("unchecked")
            List<Integer>[] list = new List[26];

            for (int i = 0; i < 26; ++i) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < S.length(); ++i) {
                list[S.charAt(i) - 'a'].add(i);
            }

            int count = 0;

            loc:
            for (String word : words) {

                int now = 0;

                for (int i = 0; i < word.length(); ++i) {
                    char          c     = word.charAt(i);

                    List<Integer> l     = list[c - 'a'];

                    int           index = Collections.binarySearch(l, now);

                    if (index < 0) {
                        index = -1 - index;
                    }

                    if (index == l.size()) {
                        continue loc;
                    }

                    now = l.get(index) + 1;
                }

                ++count;
            }

            return count;
        }
    }

    public static void main(String[] args) {
        System.out
            .println(new _792().new Solution().numMatchingSubseq("abcde", new String[] {"a", "bb", "acd", "ace"}));
    }

}
