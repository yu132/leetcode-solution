package _1000_1099;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**  
 * @ClassName: _1086  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月31日  
 *  
 */
public class _1086 {

    class Solution {

        class Temp {
            int[] arr = new int[5];
            int index = 0;
        }

        public int[][] highFive(int[][] items) {

            Map<Integer, Temp> map = new HashMap<>();

            for (int[] each : items) {
                Temp t = map.computeIfAbsent(each[0], x -> new Temp());
                int  i = 0;
                while (true) {
                    if (i == t.index) {
                        if (t.index < 5) {
                            ++t.index;
                            t.arr[i] = each[1];
                        }
                        break;
                    }
                    if (t.arr[i] < each[1]) {
                        if (5 - i - 1 > 0) {
                            System.arraycopy(t.arr, i, t.arr, i + 1, 5 - i - 1);
                        }
                        t.arr[i] = each[1];
                        if (t.index < 5) {
                            ++t.index;
                        }
                        break;
                    }
                    ++i;
                }
            }

            int[][]                        ans      = new int[map.size()][2];

            Set<Entry<Integer, Temp>>      entryset = map.entrySet();

            Iterator<Entry<Integer, Temp>> it       = entryset.iterator();

            for (int i = 0; i < entryset.size(); ++i) {

                Entry<Integer, Temp> entry = it.next();

                ans[i][0] = entry.getKey();

                int sum = 0;
                for (int j = 0; j < entry.getValue().index; ++j) {
                    sum += entry.getValue().arr[j];
                }

                ans[i][1] = sum / entry.getValue().index;
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        new _1086().new Solution().highFive(new int[][] {{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65},
            {1, 87}, {1, 100}, {2, 100}, {2, 76}});
    }

}
