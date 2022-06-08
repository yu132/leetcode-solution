package _0200_0299;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**  
 * @ClassName: _245  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月6日  
 *  
 */
public class _245 {

    class Solution {
        public int shortestWordDistance(String[] words, String word1, String word2) {
            Map<String, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < words.length; ++i) {
                map.computeIfAbsent(words[i], (x) -> new ArrayList<>()).add(i);
            }

            if (!word1.equals(word2)) {
                List<Integer> l1     = map.get(word1);
                List<Integer> l2     = map.get(word2);

                int           index1 = 0, index2 = 0;

                int           min    = Integer.MAX_VALUE;
                while (index1 != l1.size() && index2 != l2.size()) {
                    if (l1.get(index1) < l2.get(index2)) {
                        min = Math.min(min, l2.get(index2) - l1.get(index1));
                        ++index1;
                    } else {// l1.get(index1) > l2.get(index2)
                        min = Math.min(min, l1.get(index1) - l2.get(index2));
                        ++index2;
                    }
                }
                return min;
            } else {
                List<Integer> l   = map.get(word1);
                int           min = Integer.MAX_VALUE;
                for (int i = 1; i < l.size(); ++i) {
                    min = Math.min(min, l.get(i) - l.get(i - 1));
                }
                return min;
            }
        }
    }

}
