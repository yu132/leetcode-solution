package redo.p0400_0499;

import org.junit.Test;
import utils.Sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author 余定邦
 * @ClassName: P401
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2020年12月19日
 */
public class P401 {

    class Solution {

        private final int[][] data = {{8, 0}, {4, 0}, {2, 0}, {1, 0}, {0, 32}, {0, 16}, {0, 8}, {0, 4}, {0, 2}, {0, 1}};

        public List<String> readBinaryWatch(int num) {
            List<String> ans = new ArrayList<>();
            backtracking(num, 0, new ArrayList<>(), ans);
            return ans;
        }

        public void backtracking(int num, int index, List<Integer> choose, List<String> ans) {
            if (index == data.length) {
                if (num != 0) {
                    return;
                } else {
                    int hour = 0;
                    int min = 0;
                    for (int i = 0; i < choose.size(); ++i) {
                        hour += data[choose.get(i)][0];
                        min += data[choose.get(i)][1];
                    }
                    if (hour >= 12 || min >= 60) {
                        return;
                    }
                    ans.add(hour + ":" + minStr(min));
                }
                return;
            }
            if (num > 0) {
                choose.add(index);
                backtracking(num - 1, index + 1, choose, ans);
                choose.remove(choose.size() - 1);
            }
            backtracking(num, index + 1, choose, ans);
        }

        public String minStr(int min) {
            if (min < 10) {
                return "0" + min;
            } else {
                return String.valueOf(min);
            }
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Sets.asSets("1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"),
                new HashSet<>(s.readBinaryWatch(1)));
        assertEquals(Sets.asSets("11:59", "11:55", "11:47", "11:31", "7:59", "7:55", "7:47", "7:31"),
                new HashSet<>(s.readBinaryWatch(8)));
    }

}
