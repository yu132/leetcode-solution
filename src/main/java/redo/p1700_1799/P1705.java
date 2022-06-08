package redo.p1700_1799;

import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1705  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月31日  
 *  
 */
public class P1705 {

    class Solution {
        public int eatenApples(int[] apples, int[] days) {
            PriorityQueue<Apples> pq = new PriorityQueue<>();
            int appleEaten = 0;
            for (int i = 0; i < days.length; ++i) {
                pq.offer(new Apples(apples[i], i + days[i]));
                while (!pq.isEmpty() && pq.peek().rotDay <= i) {
                    pq.poll();
                }
                if (!pq.isEmpty()) {
                    ++appleEaten;
                    --pq.peek().num;
                }
            }
            int day = days.length;
            while (!pq.isEmpty()) {
                while (!pq.isEmpty() && pq.peek().rotDay <= day) {
                    pq.poll();
                }
                if (!pq.isEmpty()) {
                    Apples apps = pq.poll();
                    int appleAbleToEat = Math.min(apps.num, apps.rotDay - day);
                    appleEaten += appleAbleToEat;
                    day += appleAbleToEat;
                }
            }
            return appleEaten;
        }

        class Apples implements Comparable<Apples> {
            int num;
            int rotDay;

            public Apples(int num, int rotDay) {
                super();
                this.num = num;
                this.rotDay = rotDay;
            }

            @Override
            public int compareTo(Apples o) {
                return Integer.compare(rotDay, o.rotDay);
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(7, s.eatenApples(new int[] {1, 2, 3, 5, 2}, new int[] {3, 2, 1, 4, 2}));
        Assert.assertEquals(5, s.eatenApples(new int[] {3, 0, 0, 0, 0, 2}, new int[] {3, 0, 0, 0, 0, 2}));
        Assert.assertEquals(104, s.eatenApples(new int[] {3, 0, 0, 0, 100, 100}, new int[] {3, 0, 0, 0, 50, 100}));
        Assert.assertEquals(165,
            s.eatenApples(
                new int[] {0, 47, 47, 0, 27, 11, 24, 2, 0, 0, 32, 12, 34, 24, 40, 28, 35, 16, 0, 38, 0, 0, 30, 17, 11,
                    0, 0, 47, 0, 33, 27, 7, 43, 0, 0, 43, 41, 10, 35, 27, 43, 8, 0, 0, 10, 5, 3, 0, 1, 24, 17, 0, 17, 0,
                    0, 22, 41, 35, 0, 10, 16, 8, 10, 17, 0, 38, 35, 18, 6, 29, 9, 0, 14, 11, 0, 0, 43, 14, 17, 3, 6, 4,
                    2, 44, 6, 18, 26, 0, 23, 11, 37, 37, 1, 47},
                new int[] {0, 19, 68, 0, 37, 17, 35, 3, 0, 0, 17, 23, 2, 23, 25, 24, 51, 27, 0, 41, 0, 0, 51, 29, 21, 0,
                    0, 60, 0, 33, 50, 4, 7, 0, 0, 16, 77, 4, 44, 17, 65, 7, 0, 0, 3, 4, 3, 0, 1, 24, 1, 0, 22, 0, 0, 41,
                    62, 39, 0, 20, 3, 3, 10, 16, 0, 71, 53, 32, 8, 31, 14, 0, 15, 5, 0, 0, 15, 9, 7, 4, 3, 5, 3, 82, 5,
                    16, 25, 0, 3, 5, 57, 34, 2, 73}));
    }

}
