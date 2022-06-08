package _0300_0399;

/**  
 * @ClassName: _346  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月27日  
 *  
 */
public class _346 {

    class MovingAverage {

        private int len;
        private int lenNow;
        private int sum;

        private int[] arr;
        private int index;

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            len    = size;
            lenNow = 0;
            sum    = 0;
            arr    = new int[size];
            index  = 0;
        }

        public double next(int val) {
            if (lenNow != len) {
                ++lenNow;
                sum          += val;
                arr[index++]  = val;
                return (double)sum / lenNow;
            } else {
                index      %= len;
                sum        += val;
                sum        -= arr[index];
                arr[index]  = val;
                return (double)sum / len;
            }
        }
    }

}
