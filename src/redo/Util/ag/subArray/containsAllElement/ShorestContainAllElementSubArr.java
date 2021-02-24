package redo.Util.ag.subArray.containsAllElement;

/**  
 * @ClassName: ShorestContainAllElementSubArr  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月18日  
 *  
 */
public class ShorestContainAllElementSubArr {

    /**
     * 本问题是寻找最短的，包括所有需要包括的内容的字串
     * 
     * 此问题有两个难度，第一个是不包含重复元素（ P17_18 ），另一个则是包含（ P76 ）
     * 
     * 思路很简单，就是滑窗，每次右边加入一个元素，当满足要求的时候，左边不断删除元素
     * 直到不满足要求
     * 
     * 问题就是维护这个要求，即所有的元素是否出现，无论是否重复，都需要用哈希表来计数
     * 统计区间内相关元素的数量，有重复元素的比较会略微更困难一些
     */

}
