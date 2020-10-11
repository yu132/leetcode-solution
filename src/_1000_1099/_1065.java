package _1000_1099;

import java.util.ArrayList;
import java.util.Arrays;

/**  
 * @ClassName: _1065  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月30日  
 *  
 */
public class _1065 {

    class Solution {
        public int[][] indexPairs(String text, String[] words) {

            ArrayList<int[]> ans = new ArrayList<>();

            for (int i = 0; i < words.length; ++i) {
                int index = -1;
                while (index + 1 + words[i].length() <= text.length()) {
                    index = text.indexOf(words[i], index + 1);
                    if (index == -1) {
                        break;
                    }
                    ans.add(new int[] {index, index + words[i].length() - 1});
                }
            }

            int[][] arr = ans.toArray(new int[ans.size()][]);

            Arrays.sort(arr, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            });

            return arr;
        }
    }

}
