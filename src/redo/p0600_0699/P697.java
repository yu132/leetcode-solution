package redo.p0600_0699;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P697  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P697 {

    class Solution {
        public int findShortestSubArray(int[] nums) {
            Map<Integer, Data> map = new HashMap<>();
            for (int i = 0; i < nums.length; ++i) {
                Data data = map.computeIfAbsent(nums[i], (x) -> new Data());
                if (data.start == -1) {
                    data.start = i;
                }
                ++data.feq;
                data.last = i;
            }
            int maxFeq = 0, minLen = 0;
            for (Data data : map.values()) {
                if (data.feq > maxFeq) {
                    maxFeq = data.feq;
                    minLen = data.last - data.start;
                } else if (data.feq == maxFeq) {
                    minLen = Math.min(minLen, data.last - data.start);
                }
            }
            return minLen + 1;
        }

        class Data {
            int feq;
            int start = -1;
            int last;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.findShortestSubArray(new int[] {1, 2, 2, 3, 1}));
        Assert.assertEquals(6, s.findShortestSubArray(new int[] {1, 2, 2, 3, 1, 4, 2}));
        Assert.assertEquals(4, s.findShortestSubArray(new int[] {2, 2, 2, 3, 1, 1, 1, 1, 4, 2}));
    }

}
