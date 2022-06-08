package _0300_0399;

import java.util.List;

import _0300_0399._341.NestedInteger;

/**  
 * @ClassName: _339  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月26日  
 *  
 */
public class _339 {

    class Solution {
        public int depthSum(List<NestedInteger> nestedList) {
            return helper(nestedList, 1);
        }

        public int helper(List<NestedInteger> nestedList, int mul) {
            int count = 0;
            for (int i = 0; i < nestedList.size(); ++i) {
                if (nestedList.get(i).isInteger()) {
                    count += nestedList.get(i).getInteger() * mul;
                } else {
                    count += helper(nestedList.get(i).getList(), mul + 1);
                }
            }
            return count;
        }
    }

}
