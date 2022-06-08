package redo.offer2.p16;

/**  
 * @ClassName: P16_10  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月15日  
 *  
 */
public class P16_10 {

    class Solution {
        public int maxAliveYear(int[] birth, int[] death) {
            int[] diff = new int[102];

            for (int i = 0; i < birth.length; ++i) {
                addRange(diff, birth[i], death[i] + 1);
            }

            int count = 0, maxYear = 1900, maxCount = 0;
            for (int i = 0; i < 101; ++i) {
                count += diff[i];
                if (count > maxCount) {
                    maxCount = count;
                    maxYear = 1900 + i;
                }
            }
            return maxYear;
        }

        public void addRange(int[] diff, int start, int end) {
            start -= 1900;
            end -= 1900;
            if (start < 0) {
                start = 0;
            }
            if (end >= 102) {
                end = 101;
            }
            ++diff[start];
            --diff[end];
        }
    }

}
