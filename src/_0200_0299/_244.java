package _0200_0299;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**  
 * @ClassName: _244  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月6日  
 *  
 */
public class _244 {

    class WordDistance {

        private Map<String, List<Integer>> map;
        private Map<String, Integer> cache;

        public WordDistance(String[] words) {

            map   = new HashMap<>();
            cache = new HashMap<>();

            for (int i = 0; i < words.length; ++i) {
                map.computeIfAbsent(words[i], (x) -> new ArrayList<>()).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            if (word1.equals(word2)) {
                return 0;
            }
            if (cache.containsKey(word1 + " " + word2)) {
                return cache.get(word1 + " " + word2);
            } else if (cache.containsKey(word2 + " " + word1)) {
                return cache.get(word2 + " " + word1);
            }

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

            cache.put(word1 + " " + word2, min);
            return min;
        }
    }

    public static void main(String[] args) {
        WordDistance a = new _244().new WordDistance(new String[] {"practice", "makes", "perfect", "coding", "makes"});
        a.shortest("coding", "practice");
    }
}
