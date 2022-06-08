/**  
 * @ClassName: package-info  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月15日  
 *  
 */
package redo.Util.ag.subArray.sameAmountSubArr;

/**
 * 问题是找到包含相同数量的0和1的最长的子数组
 * 
 * 问题简化为前缀和即可，当为0时-1，为1时+1
 * 当前缀和为相同的值的两个index中间的和为0，那么中间的值相等
 * 因此问题转化为求前缀数组中相等的两个值间隔的最大距离
 */
