/**
 * @ClassName: package-info
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 余定邦
 * @date 2021年1月5日
 */
package redo.Util.ag.subArray;

/*
 * 本包存放的是和子数组相关的内容
 *
 * 1.最大和的子数组 maxSubArr
 *   dp滚动
 *   O(n) O(1)
 *
 * 2.和为某值的最长、最短、全部子数组 subArrayInSum
 *   hash
 *   最长最短（O(n) O(n)） 全部（O(n^2) O(n))）
 *   全部都大于0
 *   滑窗(O(n))
 *
 * 3.“数组值都大于0的”，最长的和小于某值的子数组 （最短的大于某值的子数组也同理）
 *   滑窗
 *   O(n) O(1)
 *
 * 4.改变最短的子数组使得数组合法，changeToRight
 *   滑窗
 *   O(n) O(1)
 *
 * 5.包含所有元素的子数组总数量
 *   滑窗
 *   O(n) O(1)
 *
 * 6.和大于(小于)某值的最长子数组
 *   前缀和转化为最大宽坡+递减栈
 *   O(n) O(n)
 *
 * 7.反向滚动哈希，字符串哈希求模（RabinKarp）时，只能power大的在前，power小的在后，如果需要反过来，就反向遍历即可
 *   见P2156
 *
 */
