/**  
 * @ClassName: package-info  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月25日  
 *  
 */
package redo.Util.ag.subArray.minSubArrGreaterThanK;

/*
 * 例子见 P862
 * 这个问题和他的反例，求最大值的问题有些不一样
 * 但是也很像，都是使用前缀和和单调队列解决问题
 * 
 * 不过此处要求的是最小值，因此问题变成了找到当prefix[j]-prefix[i]>k时，j-i的最小值
 * 应该如何找呢？
 * 
 * 我们需要维护一个单调递增队列，里面存储的是最小一些prefix[i]
 * 因为我们希望prefix[i]尽可能小，因此当出现k>i且prefix[i]<prefix[k]时，k处的值就没用了
 * 
 * 然后队列头部是最小的prefix[i]，每次有prefix[j]符合要求的时候，就弹出队首，并计算一次ans
 * 取最小的ans
 */
