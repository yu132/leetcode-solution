/**  
 * @ClassName: package-info  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月16日  
 *  
 */
package redo.Util.ag.subSeq.longestIncSeq;

/**
 * 此处是最长上升子序列的问题
 * 
 * 一维的最长上升子序列很简单，就是向栈中不断加入元素，每次元素加入的位置是元素在数组中有序的插入位置，
 * 插入将原有元素覆盖，将所有元素插入之后数组的长度就是最长上升子序列的长度
 * 
 * （后面两种其实不算子序列，因为能改变元素顺序，是顺序无关的）
 * 
 * 二维的略微复杂，需要在两个维度上都递增，不过这个问题可以降为一维的来做，
 * 只要在任意一个维度上排序，当这个维度的值相同的时候，按另一个维度的值逆向排序（为了防止第一个维度相等导致更长）
 * 然后在第二个维度上进行一维的计算即可
 * 
 * 三维的就非常复杂了，需要用O(n^2)的动态规划来解决，
 * 首先先在一个维度上排序，降低复杂度，然后再在另外两个维度上进行比较，如果都在三个维度上都更大，那么可以加
 * 
 * 一维、二维见 P17_08 三维见 P08_13
 */
