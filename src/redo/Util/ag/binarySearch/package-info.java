/**  
 * @ClassName: package-info  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月7日  
 *  
 */
package redo.Util.ag.binarySearch;
/*
 * 二分查找是一个非常经典的查找算法，其可以在有序数组中仅使用O(logn)的时间复杂度得到查找的结果
 * 
 * 但是二分查找不仅仅可以用于数组的查找，也可用于答案的查找，对于一个答案范围区间[min,max]
 * 如果答案满足某种顺序，例如需要多少数量的物品才能满足，那么少于某个指定数量的num是肯定不符合要求的
 * 因此我们可以使用二分查找来进行查找，首先先猜测一个mid，然后验证mid，如果mid不符合要求，
 * 那么最终答案一定大于mid，那么令low=mid+1，如果mid符合要求，那么答案可能是mid或者小于mid，
 * 因此令high=mid，二分到low==high时即可获取最小的符合要求的答案
 */
