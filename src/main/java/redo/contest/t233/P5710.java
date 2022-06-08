package redo.contest.t233;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.Arrs;

/**  
 * @ClassName: P5710  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月21日  
 *  
 */
public class P5710 {

    class Solution {
        public int getNumberOfBacklogOrders(int[][] orders) {
            TreeMap<Integer, long[]> sells = new TreeMap<>();
            TreeMap<Integer, long[]> buys = new TreeMap<>();

            for (int[] order : orders) {

                int price = order[0], amount = order[1], type = order[2];

                if (type == 0) {// buy 买卖价低

                    List<Integer> toRemove = new ArrayList<>();

                    for (Map.Entry<Integer, long[]> entry : sells.entrySet()) {

                        int sellPrice = entry.getKey();
                        long[] sellAmount = entry.getValue();

                        if (price < sellPrice) {
                            break;
                        }

                        if (amount >= sellAmount[0]) {
                            toRemove.add(sellPrice);
                            amount -= sellAmount[0];
                        } else {
                            sellAmount[0] -= amount;
                            amount = 0;
                            break;
                        }
                    }

                    for (int key : toRemove) {
                        sells.remove(key);
                    }

                    if (amount > 0) {
                        buys.computeIfAbsent(price, (x) -> new long[1])[0] +=
                            amount;
                    }
                } else {// sell 卖买价高
                    List<Integer> toRemove = new ArrayList<>();

                    for (Map.Entry<Integer, long[]> entry : buys.descendingMap()
                        .entrySet()) {

                        int buyPrice = entry.getKey();
                        long[] buyAmount = entry.getValue();

                        if (price > buyPrice) {
                            break;
                        }

                        if (amount >= buyAmount[0]) {
                            toRemove.add(buyPrice);
                            amount -= buyAmount[0];
                        } else {
                            buyAmount[0] -= amount;
                            amount = 0;
                            break;
                        }
                    }

                    for (int key : toRemove) {
                        buys.remove(key);
                    }

                    if (amount > 0) {
                        sells.computeIfAbsent(price, (x) -> new long[1])[0] +=
                            amount;
                    }
                }
            }

            long amount = 0;

            for (long[] val : buys.values()) {
                amount += val[0];
            }

            for (long[] val : sells.values()) {
                amount += val[0];
            }

            return (int)(amount % 1_000_000_007);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(999999984, s.getNumberOfBacklogOrders(Arrs
            .build2D("[[7,1000000000,1],[15,3,0],[5,999999995,0],[5,1,1]]")));
    }

}
