package redo.Util.ag.binarySearch;

import java.util.function.Function;

/**  
 * @ClassName: BinarySearchUtil  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月11日  
 *  
 */
public class BinarySearchUtil {

    /**
     * 二分查找的细节非常多，并且非常容易出错，因此在此处将详细描述一下二分查找的具体细节
     * 
     * 首先二分查找是只有一种类型的，并不需要区分 左边界 或者 右边界 或者 是否存在，
     * 虽然多加一个==判断能够减少二分的次数，但是增加了二分判断的复杂程度，
     * 因此我个人认为是得不偿失的
     * 
     * 左右边界完全可以相互转化，通过反转左边界条件，即可判断右边的边界
     * 
     * 下面两种写的方法是等价的，寻找符合条件的最小值的函数是这样的
     * 其在高位为真，低位为假，例如 0 0 0 0 1 1 1 1，需要返回第一个为1的位置
     * 
     * 而寻找符合条件的最大值的函数则恰好和前者相反，例如 1 1 1 1 0 0 0 0，需要返回最后一个为1的位置
     * 
     * 将函数进行反转，我们可以将第二种情况转化为第一种，只是我们求得位置发生了一点偏差，进行减一即可
     * 
     * 由于/2的特殊性，因此判断条件之后是绝对不能写出low=mid的式子，必须将其进行逻辑反转，
     * 将求符合条件的最后一个转化为不符合条件的第一个减一
     * 
     * 另外要注意边界，low对应的值是可以取的，high对应的值是不一定能取到的，
     * 
     * 对于第一种情况是都可以取的，极端条件是当所有元素都符合条件时，那么返回初始low
     * 如果全部元素都不符合条件，那么会返回初始high
     * 
     * 但是对于第二种情况就不是如此，如果全部元素都不符合条件，那么会返回low-1（而不是low）
     * 对于所有元素都符合条件，也只会返回high-1（而不是high）
     * 
     * 并且，对于judge来说，也并非所有值都是合法的，例如high通常对于数组查找来说就是数组长度，
     * 其应当不允许作为参数传入judge，否则会产生越界错误，那么有什么值会传入judge呢，
     * 答案是只有[low, high-1]会被传入，因此是无需太过担心的
     * 
     * 总结一下，对于前假后真的情况，返回值的范围为[low,high]，对于judge函数调用范围为[low,high-1]
     * 对于前真后假的情况，由于需要转换为第一种情况，并且在结果上减一，因此返回值范围变化为[low-1,high-1]
     * 对于judge函数的调用范围不变，但是judge需要进行反转后传入第一个类型的函数中
     */

    // 寻找符合条件的最小值
    public int binarySearchMin(int low, int high, Function<Integer, Boolean> judge) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (judge.apply(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // 寻找符合条件的最大值
    public int binarySearchMax(int low, int high, Function<Integer, Boolean> judge) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (judge.apply(mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low - 1;
    }

}
