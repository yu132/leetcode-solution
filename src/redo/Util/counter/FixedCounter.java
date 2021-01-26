package redo.Util.counter;

/**  
 * @ClassName: FixedCounter  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月21日  
 *  
 */
public class FixedCounter {

    static class IntFixedCounter {

        int start, arr[];

        IntFixedCounter(int start, int end) {
            this.start = start;
            arr = new int[end - start];
        }

        void plus1(int val) {
            ++arr[val - start];
        }

        void add(int val, int count) {
            arr[val - start] += count;
        }

        int get(int val) {
            if (val - start < 0 || val - start >= arr.length) {
                return 0;
            }
            return arr[val - start];
        }
    }

}
