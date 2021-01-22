package redo.Util.ds.monotonousDeque;

import redo.Util.ds.monotonousDeque.MonotonousDequeUtil.IntMonotonousDeque;

/**  
 * @ClassName: Helper  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月15日  
 *  
 */
public class Helper {

    public IntMonotonousDeque inc(int[] nums) {
        IntMonotonousDeque mqueue = new IntMonotonousDeque(nums.length);
        for (int num : nums) {
            mqueue.offerAndRemove(num, (last, now) -> last > now);
        }
        return mqueue;
    }

    public IntMonotonousDeque dec(int[] nums) {
        IntMonotonousDeque mqueue = new IntMonotonousDeque(nums.length);
        for (int num : nums) {
            mqueue.offerAndRemove(num, (last, now) -> last < now);
        }
        return mqueue;
    }

}
