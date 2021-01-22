package redo.Util.ag.subArray.maxSubArr;

/**  
 * @ClassName: MaxSubArrRemoveOneElement  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月14日  
 *  
 */
public class MaxSubArrRemoveOneElement {

    /*
     * 可以选择删除一个元素的最大子数组，需要保证子数组不为空
     * 
     * 思想是维护一个删除和不删除的两个最大值keep和remove
     * 
     * 状态转移方程
     * keep = max(lastKeep + nums[i], nums[i]) 
     * remove = max(lastRemove + nums[i], lastKeep)
     * max = max(max, keep, remove)
     * 
     * keep表示当前没有任何一个元素删除的最大值，因此最大值只能在上一个keep+当前值或者当前值中选一个
     * 
     * remove表示当前有元素被删除时的最大值，因此可以选择删除之前的元素，即上一个remove+当前值
     * 或者删除当前值，即选择上一个keep
     * 
     * 题目见leetcode-1186
     */

}
