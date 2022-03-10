package redo.Util.counter;

/**
 * @author 余定邦
 * @ClassName: FixedCounter
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2021年1月21日
 */
public class FixedCounter {

    /**
     * 相当于计数数组，就是使用数组来进行计数
     * 可以计数的范围从start开始，到end-1结束
     */
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
