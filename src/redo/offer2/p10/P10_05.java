package redo.offer2.p10;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P10_05  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月11日  
 *  
 */
public class P10_05 {

    class Solution {
        public int findString(String[] words, String s) {
            int low = 0, high = words.length - 1;
            while (low <= high) {
                int half = (low + high) >>> 1;
                int mid = findLeft(words, half, low);
                if (mid < low) {
                    mid = findRight(words, half, high);
                    if (mid > high) {
                        return -1;
                    }
                }
                int comp = s.compareTo(words[mid]);
                if (comp > 0) {
                    low = mid + 1;
                } else if (comp < 0) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }

        public int findLeft(String[] words, int index, int low) {
            while (index >= low && index > 0 && words[index].equals("")) {
                --index;
            }
            return index;
        }

        public int findRight(String[] words, int index, int high) {
            while (index <= high && index < words.length
                && words[index].equals("")) {
                ++index;
            }
            return index;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(-1, s.findString(new String[] {"at", "", "", "",
            "ball", "", "", "car", "", "", "dad", "", ""}, "ta"));
    }
}
