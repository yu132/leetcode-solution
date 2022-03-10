package redo.p0400_0499;

import java.util.Arrays;

/**  
 * @ClassName: P451  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月18日  
 *  
 */
public class P451 {

    class Solution {
        public String frequencySort(String s) {
            int[] count = new int[128];

            for (char ch : s.toCharArray()) {
                ++count[ch];
            }

            Integer[] indexes = new Integer[128];

            Arrays.setAll(indexes, (x) -> x);

            Arrays.sort(indexes, (a, b) -> Integer.compare(count[b], count[a]));

            char[] ans = new char[s.length()];

            int index = 0;

            for (int i : indexes) {
                for (int c = 0; c < count[i]; ++c) {
                    ans[index++] = (char)i;
                }
            }

            return String.valueOf(ans);
        }
    }

}
