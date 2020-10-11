package _1300_1399;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**  
 * @ClassName: _1356  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月11日  
 *  
 */
public class _1356 {

    class Solution {
        public int[] sortByBits(int[] arr) {
            int[] map = new int[10001];
            for (int each : arr) {
                map[each] = countBinaryOne(each);
            }
            List<Integer> list = toList(arr);
            Collections.sort(list, (a, b) -> {
                return map[a] == map[b] ? Integer.compare(a, b) : Integer.compare(map[a], map[b]);
            });
            for (int i = 0; i < arr.length; ++i) {
                arr[i] = list.get(i);
            }
            return arr;
        }

        public List<Integer> toList(int[] array) {
            List<Integer> list = new ArrayList<>(array.length);
            for (int each : array) {
                list.add(each);
            }
            return list;
        }

        public int countBinaryOne(int num) {

            int count = 0;
            while (num != 0) {
                count  += num & 1;
                num   >>= 1;
            }

            return count;
        }
    }

}
