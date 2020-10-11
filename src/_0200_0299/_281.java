package _0200_0299;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _281  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月10日  
 *  
 */
public class _281 {

    public class ZigzagIterator {

        private List<Integer> ans = new ArrayList<>();
        private int index = 0;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            List<List<Integer>> data = new ArrayList<>();
            data.add(v1);
            data.add(v2);

            int[]   indexes = new int[data.size()];
            int     i       = 0;
            boolean noMore  = true;

            while (true) {
                if (i == data.size()) {
                    if (noMore) {
                        break;
                    }
                    noMore = true;
                    i      = 0;
                }
                List<Integer> list  = data.get(i);
                int           index = indexes[i];
                if (index == list.size()) {
                    ++i;
                    continue;
                }
                noMore = false;
                ans.add(list.get(index));
                ++indexes[i];
                ++i;
            }
        }

        public int next() {
            return ans.get(index++);
        }

        public boolean hasNext() {
            return index != ans.size();
        }
    }

}
