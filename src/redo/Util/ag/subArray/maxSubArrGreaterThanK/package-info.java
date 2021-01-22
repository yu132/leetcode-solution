/**  
 * @ClassName: package-info  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月15日  
 *  
 */
package redo.Util.ag.subArray.maxSubArrGreaterThanK;

/*
 * 此处是和大于某值的最长子数组求法
 * 
 * 思想很不好想，因此下面直接说解法
 * 
 * 解法是一个转换过程，首先先求出数组前缀和
 * 那么和大于某值的子数组转化为求前缀和数组prefix[j]-prefix[i]>k时，j-i的最大值
 * 
 * 而我们恰好发现这就是一个最大宽坡问题，因此直接使用maxWidthRamp中的解法即可
 * 
 * 如果是求和小于某值的最长子数组
 * 我们可以通过对前缀和数组求反，然后令条件变为prefix[j]-prefix[i]>-k
 */
