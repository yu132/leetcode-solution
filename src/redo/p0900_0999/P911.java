package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P911  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月25日  
 *  
 */
public class P911 {

    static//

    class TopVotedCandidate {

        int[] indexes, winner;

        public TopVotedCandidate(int[] persons, int[] times) {

            int n = persons.length;

            indexes = times;
            winner = new int[n];

            IntFixedCounter counter = new IntFixedCounter(0, n + 1);

            int max = -1, maxCount = 0;

            for (int i = 0; i < n; ++i) {
                counter.plus1(persons[i]);
                if (counter.get(persons[i]) >= maxCount) {
                    maxCount = counter.get(persons[i]);
                    max = persons[i];
                }
                winner[i] = max;
            }
        }

        public int q(int t) {
            int index = lowerBound(indexes, t, 0, indexes.length);
            return winner[index];
        }

        public int lowerBound(int[] nums, int target, int start, int end) {
            int low = start, high = end;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (nums[mid] < target + 1) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low - 1;
        }

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



    @Test
    public void test() {
        TopVotedCandidate s =
            new TopVotedCandidate(new int[] {0, 1, 1, 0, 0, 1, 0}, new int[] {0, 5, 10, 15, 20, 25, 30});
        Assert.assertEquals(0, s.q(3));
        Assert.assertEquals(1, s.q(12));
        Assert.assertEquals(1, s.q(25));
        Assert.assertEquals(0, s.q(15));
        Assert.assertEquals(0, s.q(24));
        Assert.assertEquals(1, s.q(8));
    }

}
