package redo.p1600_1699;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1604  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月3日  
 *  
 */
public class P1604 {

    class Solution {
        public List<String> alertNames(String[] keyName, String[] keyTime) {
            List<String> ans = new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();

            for (int i = 0; i < keyName.length; ++i) {
                map.computeIfAbsent(keyName[i], (x) -> new ArrayList<>()).add(keyTime[i]);
            }

            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String name = entry.getKey();
                List<String> times = entry.getValue();
                Collections.sort(times);
                Deque<String> deque = new LinkedList<>();
                for (String time : times) {
                    while (!deque.isEmpty() && moreThanOneHour(deque.peekFirst(), time)) {
                        deque.pollFirst();
                    }
                    deque.addLast(time);
                    if (deque.size() >= 3) {
                        ans.add(name);
                        break;
                    }
                }
            }

            Collections.sort(ans);

            return ans;
        }

        public boolean moreThanOneHour(String time1, String time2) {
            int hourDiff = Integer.valueOf(time2.substring(0, 2)) - Integer.valueOf(time1.substring(0, 2));
            if (hourDiff > 1) {
                return true;
            } else if (hourDiff == 0) {
                return false;
            }
            return time1.substring(3, 5).compareTo(time2.substring(3, 5)) < 0;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList("daniel"),
            s.alertNames(new String[] {"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"},
                new String[] {"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"}));
        Assert.assertEquals(Arrays.asList("bob"),
            s.alertNames(new String[] {"alice", "alice", "alice", "bob", "bob", "bob", "bob"},
                new String[] {"12:01", "12:00", "18:00", "21:00", "21:20", "21:30", "23:00"}));
        Assert.assertEquals(Arrays.asList(),
            s.alertNames(new String[] {"john", "john", "john"}, new String[] {"23:58", "23:59", "00:01"}));
        Assert.assertEquals(Arrays.asList("clare", "leslie"),
            s.alertNames(new String[] {"leslie", "leslie", "leslie", "clare", "clare", "clare", "clare"},
                new String[] {"13:00", "13:20", "14:00", "18:00", "18:51", "19:30", "19:49"}));
        Assert.assertEquals(Arrays.asList("a"),
            s.alertNames(new String[] {"a", "a", "a", "a", "a", "a", "b", "b", "b", "b", "b"}, new String[] {"23:27",
                "03:14", "12:57", "13:35", "13:18", "21:58", "22:39", "10:49", "19:37", "14:14", "10:41"}));

    }

}
