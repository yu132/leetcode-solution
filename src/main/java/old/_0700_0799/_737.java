package old._0700_0799;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**  
 * @ClassName: _737  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月15日  
 *  
 */
public class _737 {

    class Solution {
        public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {

            if (words1.length != words2.length) {
                return false;
            }

            Map<String, Integer> indexMap = new HashMap<>();

            for (List<String> each : pairs) {
                for (String str : each) {
                    if (!indexMap.containsKey(str)) {
                        indexMap.put(str, indexMap.size());
                    }
                }
            }

            UF uf = new UF(indexMap.size());

            for (List<String> each : pairs) {
                uf.union(indexMap.get(each.get(0)), indexMap.get(each.get(1)));
            }

            for (int i = 0; i < words1.length; ++i) {
                if (!indexMap.containsKey(words1[i]) || !indexMap.containsKey(words2[i])) {
                    if (!words1[i].equals(words2[i])) {
                        return false;
                    }
                } else {
                    if (!uf.connected(indexMap.get(words1[i]), indexMap.get(words2[i]))) {
                        return false;
                    }
                }
            }

            return true;
        }

        public class UF {
            private int[] size;

            protected int count;

            protected int[] uf;

            public boolean connected(int element1, int element2) {
                return find(element1) == find(element2);
            }

            public int count() {
                return count;
            }

            public UF(int typeNumber) {
                this.uf = new int[typeNumber];
                count   = typeNumber;
                for (int i = 0; i < typeNumber; i++) {
                    uf[i] = i;
                }
                size  = new int[typeNumber];
                count = typeNumber;
                Arrays.fill(size, 1);
            }

            public int find(int element) {
                return uf[element] == element ? element : (uf[element] = find(uf[element]));
            }

            public void union(int element1, int element2) {
                int type1 = find(element1);
                int type2 = find(element2);

                if (type1 == type2)
                    return;

                if (size[type1] < size[type2]) {
                    uf[type1]    = type2;
                    size[type2] += size[type1];
                } else {
                    uf[type2]    = type1;
                    size[type1] += size[type2];
                }
                --count;
            }
        }
    }

}
