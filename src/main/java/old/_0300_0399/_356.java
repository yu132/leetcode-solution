package old._0300_0399;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**  
 * @ClassName: _356  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月12日  
 *  
 */
public class _356 {

    class Solution {
        public boolean isReflected(int[][] points) {

            if (points.length == 0) {
                return true;
            }

            Map<Integer, List<Integer>> map = new HashMap<>();

            for (int[] point : points) {
                map.computeIfAbsent(point[1], (x) -> new ArrayList<>()).add(point[0]);
            }

            double  mid = 0;
            boolean f   = true;
            for (List<Integer> list : map.values()) {
                Collections.sort(list);

                int size = unique(list);
                list = list.subList(0, size);

                if (f) {
                    f = false;
                    if ((list.size() & 1) == 1) {
                        mid = list.get(list.size() / 2);
                    } else {
                        mid = ((double)list.get(0) + list.get(list.size() - 1)) / 2;
                    }
                } else {
                    if ((list.size() & 1) == 1) {
                        if (Double.compare(list.get(list.size() / 2), mid) != 0) {
                            return false;
                        }
                    }
                }
                for (int i = 0; i < list.size() / 2; ++i) {
                    if (Double.compare(((double)list.get(i) + list.get(list.size() - 1 - i)) / 2, mid) != 0) {
                        return false;
                    }
                }
            }

            return true;
        }

        public int unique(List<Integer> list) {
            int now = 0, mid = 0;

            while (++mid != list.size()) {
                if (list.get(now) != list.get(mid)) {
                    list.set(++now, list.get(mid));
                }
            }

            return now + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new _356().new Solution().isReflected(new int[][] {{0, 0}, {1, 0}}));
    }
}
