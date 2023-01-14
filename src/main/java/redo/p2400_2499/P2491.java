package redo.p2400_2499;

public class P2491 {

    class Solution {
        public long dividePlayers(int[] skill) {
            long sum = sumLong(skill);
            if (sum % (skill.length / 2) != 0) {
                return -1;
            }
            long balance = sum / (skill.length / 2);
            IntFixedCounter counter = new IntFixedCounter(1, 1001);
            for (int val : skill) {
                counter.plus1(val);
            }
            long ans = 0;
            for (int val : skill) {
                if (counter.get(val) > 0) {
                    if (counter.get((int) (balance - val)) == 0) {
                        return -1;
                    }
                    ans += (balance - val) * val;
                    counter.minus1(val);
                    counter.minus1((int) (balance - val));
                }
            }
            return ans;
        }

        long sumLong(int[] nums) {
            long sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }

        /**
         * 相当于计数数组，就是使用数组来进行计数
         * 可以计数的范围从start开始，到end-1结束
         */
        class IntFixedCounter {

            int start, arr[];

            IntFixedCounter(int start, int end) {
                this.start = start;
                arr = new int[end - start];
            }

            void plus1(int val) {
                ++arr[val - start];
            }

            void minus1(int val) {
                --arr[val - start];
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

}
