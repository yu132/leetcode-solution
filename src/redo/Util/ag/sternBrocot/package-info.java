/**  
 * @ClassName: package-info  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月8日  
 *  
 */
package redo.Util.ag.sternBrocot;

/*
 * 此问题是用于生成以1-N为底的所有真分数（法雷数列）的算法
 * 
 * 思想也不算难，可以看https://www.cnblogs.com/Zeronera/p/11372505.html来了解
 * 知道实现即可，实现就是从0,1,1,1开始，另其为a,b,c,d
 * 每次递归首先遍历a+c,b+d,c,d，然后将(a+b)/(c+d)这个分数加入答案中，
 * 然后再遍历a,b,a+c,b+d这个通式，每次需要检查底是否大于N，即c+d应当小于等于N时才继续迭代
 */
