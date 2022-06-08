/**  
 * @ClassName: package-info  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月6日  
 *  
 */
package redo.Util.ag.notRepeatGreaterValue;

/*
 * 本问题即对于一个有序数组nums，对于query数组中每一个元素，返回比大于等于query[i]的第一个元素
 * 但是不能使用相同的元素，如果没有更大的元素，则为-1，返回对应的结果数组
 * 
 * 思想是维护一个next数组，next数组指向本index及大于该index的第一个可以使用的元素
 * 
 * 当我们选择index=i的元素时，next[i]就应当指向i+1，不过next[i+1]不一定等于i+1，因此还可能指向更后面的元素，
 * 此处借用并查集中路径压缩的思想，当我们向后查找第一个可以使用的元素时，对于查找过程中的每一个next，都指向
 * 第一个可以使用的元素，例如i,i+1,i+2,i+3四个index，每个index都指向下一个index，此时第一个可用的index为i+4
 * 因此另四个index都指向i+4，从而降低时间复杂度
 * 
 * 例子为leetcode-1488 @P1488
 */
