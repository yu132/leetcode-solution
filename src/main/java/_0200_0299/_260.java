package _0200_0299;

/**  
 * @ClassName: _260  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月22日  
 *  
 */
public class _260 {

    /**
     *  这个题目的解答比较难理解，我这里写一下
     *  首先，我们需要异或全部元素，然后我们能得到只出现一次元素中有哪些位不同
     *  我们使用lowbit能取出最低位不同的数字（lowbit=x&-x）
     *  然后我们就知道lowbit这位中这两个数字是不同的，因此我们用这位将数组划分成两组
     *  其中一组的数字和lowbit与结果为0，另一组为1
     *  而两个重复的数字总是会和lowbit与出相同的结果
     *  到目前为止，就将原来的问题划分成了一个数组中有个只出现一次的元素
     *  将该组的元素全部异或就可以得到结果
     *  
     * @ClassName: Solution  
     *
     * @Description: TODO(这里用一句话描述这个类的作用)  
     *
     * @author 余定邦  
     *
     * @date 2020年2月22日  
     *
     */

    class Solution {
        public int[] singleNumber(int[] nums) {
            int xor = 0;

            for (int each : nums) {
                xor ^= each;
            }

            int   lowbit = xor & -xor;

            int[] ans    = new int[2];

            for (int each : nums) {
                if ((each & lowbit) == 0) {
                    ans[0] ^= each;
                } else {
                    ans[1] ^= each;
                }
            }

            return ans;
        }
    }

}
