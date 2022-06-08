/**  
 * @ClassName: package-info  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月28日  
 *  
 */
package redo.Util.ag.array.maxDisToPlace;
/*
 * 在区间内尽可能远的分配一个空的位置，并且要支持回收
 * 
 * 其实就是不重叠的区间合并和拆分的问题，不重叠的区间合并问题见ag.rangeMerge
 * 
 * 这里需要维护left和right两个Map，分别存储以left_i为左端点的区间和以right_i为右端点的区间
 * 然后查找某个区间就变为线性的了
 * 
 * 寻找最大区间使用红黑树优化，即可在O(logn)的时间内完成找到最大区间，以及完成对合并区间时区间的删除
 * 
 * 寻找最大的区间即从红黑树中找到最大的区间O(logn)，从map中删除旧的区间O(1)，从红黑树中删除旧的区间O(logn)
 * 插入两个新的区间O(logn)+2*O(1)
 * 
 * 回收某个位置即找到中间点对应的左边的区间和右边的区间，然后合并成一个区间即可，复杂度总和同理为O(logn)
 * 
 * 题目见leetcode-855
 */
