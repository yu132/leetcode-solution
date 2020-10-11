package _1200_1299;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _1272  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月14日  
 *  
 */
public class _1272 {

    class Solution {
        public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
            int[] temp = new int[intervals.length * 2];
            for (int i = 0; i < intervals.length; ++i) {
                temp[i * 2]     = intervals[i][0];
                temp[i * 2 + 1] = intervals[i][1];
            }

            int                 f      = lowerBound(temp, 0, temp.length, toBeRemoved[0]);
            int                 b      = lowerBound(temp, 0, temp.length, toBeRemoved[1]);

            List<List<Integer>> ans    = new ArrayList<>();

            boolean             banned = false;;
            for (int i = 0; i < temp.length; i += 2) {
                if (i == f || i + 1 == f) {

                    if (i + 1 == f) {

                        List<Integer> list = new ArrayList<>();
                        list.add(temp[i]);
                        list.add(toBeRemoved[0]);
                        ans.add(list);
                    }

                    banned = true;
                }
                if (i == b || i + 1 == b) {

                    if (i == b) {
                        List<Integer> list = new ArrayList<>();
                        list.add(temp[i]);
                        list.add(temp[i + 1]);
                        ans.add(list);
                    } else if (i + 1 == b && temp[i + 1] != toBeRemoved[1]) {
                        List<Integer> list = new ArrayList<>();
                        list.add(toBeRemoved[1]);
                        list.add(temp[i + 1]);
                        ans.add(list);
                    }

                    banned = false;
                } else {
                    if (banned) {
                        continue;
                    }

                    List<Integer> list = new ArrayList<>();
                    list.add(temp[i]);
                    list.add(temp[i + 1]);
                    ans.add(list);
                }
            }

            return ans;
        }

        public int lowerBound(int[] array, int from, int size, int key) {
            int first = from, middle;
            int half, len;
            len = size;

            while (len > 0) {
                half   = len >> 1;
                middle = first + half;
                if (array[middle] < key) {
                    first = middle + 1;
                    len   = len - half - 1; // 在右边子序列中查找
                } else
                    len = half; // 在左边子序列（包含middle）中查找
            }
            return first;
        }
    }

}
