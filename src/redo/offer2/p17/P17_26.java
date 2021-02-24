package redo.offer2.p17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**  
 * @ClassName: P17_26  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月19日  
 *  
 */
public class P17_26 {

    class Solution {
        public List<String> computeSimilarities(int[][] docs) {

            int n = docs.length;

            Map<Integer, List<Integer>> listMap = new HashMap<>();

            int[][] count = new int[n][n];

            for (int i = 0; i < n; ++i) {
                int[] doc = docs[i];
                for (int ele : doc) {
                    add(listMap, ele, i);
                }
            }

            listMap.forEach((k, v) -> {
                for (int i : v) {
                    for (int j : v) {
                        ++count[i][j];
                        ++count[j][i];
                    }
                }
            });

            List<String> ans = new ArrayList<>();

            for (int i = 1; i < n; ++i) {
                for (int j = 0; j < i; ++j) {
                    int intersection = count[i][j] / 2,
                        union = docs[i].length + docs[j].length - intersection;
                    double sim = (double)intersection / union;
                    if (sim <= 0.00005) {
                        continue;
                    }
                    ans.add(j + "," + i + ": " + String.format("%.4f", sim));
                }
            }
            return ans;
        }

        void add(Map<Integer, List<Integer>> listMap, Integer ele, int doc) {
            listMap.computeIfAbsent(ele, (x) -> new ArrayList<>()).add(doc);
        }
    }

}
