/**  
 * @ClassName: package-info  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月13日  
 *  
 */
package redo.Util.ag.subArray.changeToRight;

/*
 * 替换字串使得整个字符串合法，以leetcode-1234为例
 * 
 * 整个字符串需要满足某个需求，如果字符串不满足要求，那么需要替换某个最短的字串使得其合法
 * 思想是维护一个滑动窗口，窗口内是需要替换的字串，窗口外是合法的部分
 * 
 * 我们如果想要使得窗外的部分尽可能的合法，就需要使得窗外的元素尽可能的少，
 * 因为在窗内的元素是可以任意替换的，只要替换就必然能够使得整个串合法
 * 
 * 一开始左指针和右指针都是在最左的，每次右指针右移，都使得窗外元素减少了，这样就使得窗外元素尽可能的合法
 * 而对于每个合法的窗外情况，我们要尽可能的缩小窗内元素，去使得最终的答案最小，因此就需要同时将左指针右移
 * 但是左指针能够移动的情况必须要保证窗外元素合法，如果窗外元素不合法，那么我们就暂时不移动左指针
 * 
 * 对于每次左指针更新，都表示此时窗外是一个合法情况，此时我们更新答案，取最小的窗长作为结果
 */