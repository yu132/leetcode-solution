package redo.Util.ag.subArray.maxSubArr;

/**  
 * @ClassName: MaxLoopSubArr  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月25日  
 *  
 */
public class MaxLoopSubArr {

    /*
     * 循环子数组变体
     * 循环数组即和循环链表一样，是头尾相接的
     * 
     * 变体也很简单，只要求两次kadane即可
     * 第一次求正常的数组的最大值，第二次求除了头尾的数组最小值
     * 答案即为max(max,sum-min)
     * max表示第一次的答案，sum表示数组求和，min表示数组最小值
     * 
     * max表示正常数组的子数组最大和，sum-min表示包含第一个元素和最后一个元素的子数组最大和
     * 
     * 题目见leetcode-918
     */

}
