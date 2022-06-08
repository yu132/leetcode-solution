package _1200_1299;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _1213  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月1日  
 *  
 */
public class _1213 {

    class Solution {
        public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
            int[]              ans  = compare(compare(arr1, arr2), arr3);
            ArrayList<Integer> list = new ArrayList<>();
            for (int each : ans) {
                list.add(each);
            }
            return list;
        }

        public int[] compare(int[] a, int[] b) {
            int                indexA = 0, indexB = 0;
            ArrayList<Integer> list   = new ArrayList<>();
            while (indexA != a.length && indexB != b.length) {
                if (a[indexA] == b[indexB]) {
                    list.add(a[indexA]);
                    ++indexA;
                    ++indexB;
                } else if (a[indexA] > b[indexB]) {
                    ++indexB;
                } else {
                    ++indexA;
                }
            }
            int[] c = new int[list.size()];
            for (int i = 0; i < list.size(); ++i) {
                c[i] = list.get(i);
            }
            return c;
        }
    }

}
