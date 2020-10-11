package _1300_1399;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**  
 * @ClassName: _1338  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月29日  
 *  
 */
public class _1338 {

    class Solution {
        public int minSetSize(int[] arr) {

            Map<Integer, Integer> counter = new HashMap<>();

            for (int each : arr) {
                counter.put(each, counter.getOrDefault(each, 0) + 1);
            }

            List<Integer> list = new ArrayList<>(counter.values());

            Collections.sort(list);

            int num = arr.length;
            for (int i = list.size() - 1; i >= 0; --i) {
                num -= list.get(i);
                if (num <= arr.length / 2) {
                    return list.size() - i;
                }
            }

            return -1;
        }
    }

}
