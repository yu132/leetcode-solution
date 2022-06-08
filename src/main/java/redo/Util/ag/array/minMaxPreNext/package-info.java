/**  
 * @ClassName: package-info  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月25日  
 *  
 */
package redo.Util.ag.array.minMaxPreNext;
/*
 * 求某个位置上之前（后）的最小（大）值
 * 
 * 利用单调栈即可解
 * 
 * 通过将大的元素抛出栈，当前栈顶即为比自己小的值，然后将这个值赋值给数组即可
 */
