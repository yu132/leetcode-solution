/**  
 * @ClassName: package-info  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
package redo.Util.ag.subArray.containsAllElement;
/*
 * 求包含所有元素的子数组的数量，
 * 例如对于abcbbcbabcbabaabc这样的字符串中，需要获取包含至少1个abc的字串的数量
 * 
 * 例题见leetcode-1358
 * 
 * 有两种不同的思想，都非常好，都是O(k*n)的，k指的是需要包含的元素数量，n表示数组的长度
 * 
 * 第一种思想，记录最后出现的元素位置：
 * 通过一个数组记录每个需要的元素最后出现的位置，例如当前为a，将a的index记录在数组中，记为j
 * 获取所有元素最后出现的位置，取其中的最小值i，最大值明显为当前a的index：j
 * 那么i-j即为包含abc的最小字串，那么其向左扩展的所有字串都一定包含abc，那么就符合要求
 * 我们无视右边的串，是为了防止重复，之后向右边遍历时，一定会再次计算，因此无需向右扩展计算，
 * 只需要向右遍历即可
 * 
 * 以aaaabcbcaaa为例,|左边的即为可以扩展的符合要求的字串，（不扩展也是符符合要求的，因此是|左边长度+1）
 * a
 * aa
 * aaa
 * aaaa
 * aaaab
 * aaa|abc +4
 * aaa|abcb +4
 * aaa|abcbc +4
 * aaaabc|bca +7
 * aaaabc|bcaa +7
 * aaaabc|bcaaa +7
 * 
 * 第二种思想，使用双指针的思想：（可以进行扩展，可以不仅仅包括1个，可以限制必须包含2个以上）
 * 这种思想是统计当前串中包含的每个元素的数量，如果当前串含有所有的元素，那么向右扩展一定符合要求
 * 如果当前符合要求，那么左指针右移，如果当前不符合要求，那么右指针右移
 * 
 * 以aaaabcbcaaa为例,()内为当前的字串，|右边的可以向右扩展的符合要求的字串
 * (a)aaabcbcaaa
 * (aa)aabcbcaaa
 * (aaa)abcbcaaa
 * (aaaa)bcbcaaa
 * (aaaab)cbcaaa
 * (aaaabc)|bcaaa +6
 * a(aaabc)|bcaaa +6
 * aa(aabc)|bcaaa +6
 * aaa(abc)|bcaaa +6
 * aaaa(bc)bcaaa
 * aaaa(bcb)caaa
 * aaaa(bcbc)aaa
 * aaaa(bcbca)|aa +3
 * aaaab(cbca)|aa +3
 * aaaabc(bca)|aa +3
 * aaaabcb(ca)aa
 * aaaabcb(caa)a
 * aaaabcb(caaa)
 * 
 */
