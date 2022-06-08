package _0700_0799;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**  
 * @ClassName: _760  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月29日  
 *  
 */
public class _760 {

    class Solution {
        public int[] anagramMappings(int[] A, int[] B) {

            Map<Integer, List<Integer>> map = new HashMap<>();

            for (int i = 0; i < B.length; ++i) {
                map.computeIfAbsent(B[i], x -> new ArrayList<>()).add(i);
            }

            for (int i = 0; i < A.length; ++i) {
                List<Integer> list = map.get(A[i]);
                B[i] = list.remove(list.size() - 1);
            }

            return B;
        }
    }

}
