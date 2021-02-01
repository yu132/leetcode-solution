package redo.p0800_0899;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P881  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月27日  
 *  
 */
public class P881 {

    class Solution {
        public int numRescueBoats(int[] people, int limit) {
            Arrays.sort(people);
            int low = 0, high = people.length - 1, ans = 0;
            while (low < high) {
                if (people[low] + people[high] <= limit) {
                    ++ans;
                    ++low;
                    --high;
                } else {
                    ++ans;
                    --high;
                }
            }
            return low == high ? ans + 1 : ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.numRescueBoats(new int[] {1, 2}, 3));
        Assert.assertEquals(3, s.numRescueBoats(new int[] {3, 2, 2, 1}, 3));
        Assert.assertEquals(4, s.numRescueBoats(new int[] {3, 5, 3, 4}, 5));
    }

}
