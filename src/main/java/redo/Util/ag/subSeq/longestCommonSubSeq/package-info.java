/**  
 * @ClassName: package-info  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月14日  
 *  
 */
package redo.Util.ag.subSeq.longestCommonSubSeq;

/*
 * 最长公共子序列是一个很经典的问题，但是也很容易忘记，因此在这里记录一下
 * 
 * 思想是套一层双重循环，比较str1和str2的所有i,j对
 * 
 * 对于某一个i,j，如果str1[i]==str2[j]，那么我铁定在这个位置上延长，因此在str1[0:i]和str2[0:j]的最长公共子序列上加一
 * 如果当前str1[i]!=str2[j]，那么因为当前不相等，因此我们肯定不能将两者同时延长，因此只能选择一个
 * 因此就是在str1[0:i+1]和str2[0:j]  或者   str1[0:i]和str2[0:j+1]的最长公共子序列中选择一个最大的值
 * 
 * 以状态方程表示为：
 * 
 *          {   0                           if  i==0 || j==0
 *  c[i,j]= {   c[i-1,j-1]+1                if  i>0 && j>0 && a[i]=b[j]
 *          {   max{c[i-1,j], c[i,j-1]}     if  i>0 && j>0 && a[i]!=b[j]
 *          
 * 例子见leetcode-1143，使用了滚动数组优化空间为O(n) P1143
 */
