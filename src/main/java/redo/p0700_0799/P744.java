package redo.p0700_0799;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P744  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P744 {

    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int insertIndex = upperBound(letters, target, 0, letters.length);
            if (insertIndex < letters.length) {
                return letters[insertIndex];
            }
            return letters[0];
        }

        public int upperBound(char[] nums, int target, int start, int end) {
            int low = start, high = end;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (nums[mid] <= target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals('c', s.nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'a'));
        Assert.assertEquals('c', s.nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'j'));
        Assert.assertEquals('c', s.nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'k'));
    }

}
