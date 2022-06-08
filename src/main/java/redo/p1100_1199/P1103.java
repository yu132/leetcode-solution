package redo.p1100_1199;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1103  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class P1103 {

    class Solution {
        public int[] distributeCandies(int candies, int num_people) {
            int time = 1;
            while (true) {
                int eachTime = eachTime(time, num_people);
                if (candies < eachTime) {
                    break;
                }
                candies -= eachTime;
                ++time;
            }
            int[] ans = new int[num_people];
            for (int i = 0; i < ans.length; ++i) {
                ans[i] = count(time - 1, i, num_people);
            }
            for (int i = 0; i < ans.length && candies > 0; ++i) {
                int candie = (time - 1) * num_people + (i + 1);
                if (candies < candie) {
                    ans[i] += candies;
                    break;
                } else {
                    ans[i] += candie;
                    candies -= candie;
                }
            }
            return ans;
        }

        public int count(int times, int index, int numOfPeoplr) {
            return sum1toN(times - 1) * numOfPeoplr + times * (index + 1);
        }

        public int eachTime(int times, int numOfPeoplr) {
            return (times - 1) * numOfPeoplr * numOfPeoplr + sum1toN(numOfPeoplr);
        }

        public int sum1toN(int N) {
            return (int)((long)N * (N + 1) / 2);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {1, 2, 3, 1}, s.distributeCandies(7, 4));
        Assert.assertArrayEquals(new int[] {5, 2, 3}, s.distributeCandies(10, 3));
        Assert
            .assertArrayEquals(
                new int[] {267484, 267648, 267812, 267976, 268140, 268304, 268468, 268632, 268796, 266668, 265853,
                    266016, 266179, 266342, 266505, 266668, 266831, 266994, 267157, 267320},
                s.distributeCandies(5345793, 20));
    }

}
