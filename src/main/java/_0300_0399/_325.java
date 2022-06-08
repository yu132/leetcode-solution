package _0300_0399;

import java.util.HashMap;

/**  
 * @ClassName: _325  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月10日  
 *  
 */
public class _325 {

    /**
     * 
     * 本题的目标就是为了找到某个区间，其和为k
     * 
     * 一个很简单的思路是什么呢
     * 
     * 就是先计算前n个数的和，然后和k比较是否相等，如果不相等，那么去找之前的前m个数是否有sum(n)-sum(m)=k的情况
     * 如果有的话，那么区间(m,n]就是我们要找的范围之一，对于全部的位置都检查这样的结果是否存在，如果不存在，那么就真的不存在
     * 
     *
     */

    class Solution {
        public int maxSubArrayLen(int[] nums, int k) {
            if (nums.length == 0) {
                return 0;
            }
            HashMap<Integer, Integer> map = new HashMap<>();

            int                       max = nums[0] == k ? 1 : 0;
            map.put(nums[0], 0);
            for (int i = 1; i < nums.length; ++i) {
                nums[i] = nums[i] + nums[i - 1];
                if (nums[i] == k) {
                    max = i + 1;
                } else if (map.containsKey(nums[i] - k)) {
                    max = Math.max(max, i - map.get(nums[i] - k));
                }
                if (!map.containsKey(nums[i])) {
                    map.put(nums[i], i);
                }
            }

            return max;
        }
    }

}
