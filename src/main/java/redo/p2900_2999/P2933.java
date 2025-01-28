package redo.p2900_2999;

import redo.testUtil.Arrs;
import timetest.comparator.A;

import java.util.*;

public class P2933 {

    class Solution {
        public List<String> findHighAccessEmployees(List<List<String>> access_times) {
            Set<String> ans = new HashSet<>();
            Map<String, TreeMap<Integer, Integer>> map = new HashMap<>();
            for (List<String> val : access_times) {
                String name = val.get(0);

                if (ans.contains(name)) {
                    continue;
                }

                String time = val.get(1);

                TreeMap<Integer, Integer> treeMap = map.computeIfAbsent(name, x -> new TreeMap<>());

                int tt = parseTime(time);
                treeMap.merge(tt, 1, Integer::sum);
                Integer lowKey2, lowKey1 = null;
                lowKey2 = treeMap.lowerKey(tt);
                if (null != lowKey2) {
                    lowKey1 = treeMap.lowerKey(lowKey2);
                }
                Integer highKey2, highKey1 = null;
                highKey2 = treeMap.higherKey(tt);
                if (null != highKey2) {
                    highKey1 = treeMap.higherKey(highKey2);
                }
                // lowKey1 lowKey2 tt highKey2 highKey1
                if (null != lowKey1 && tt - lowKey1 <= 59) {
                    ans.add(name);
                } else if (null != lowKey2 && tt - lowKey2 <= 59 && treeMap.get(lowKey2) + treeMap.get(tt) >= 3) {
                    ans.add(name);
                } else if (null != lowKey2 && null != highKey2 && highKey2 - lowKey2 <= 59) {
                    ans.add(name);
                } else if (null != highKey2 && highKey2 - tt <= 59 && treeMap.get(highKey2) + treeMap.get(tt) >= 3) {
                    ans.add(name);
                } else if (null != highKey1 && highKey1 - tt <= 59) {
                    ans.add(name);
                }
            }
            return new ArrayList<>(ans);
        }

        int parseTime(String time) {
            return Integer.parseInt(time.substring(0, 2)) * 60
                    + Integer.parseInt(time.substring(2, 4));
        }
    }

    public static void main(String[] args) {
        new P2933().new Solution().findHighAccessEmployees(Arrs.build2DsL("[[\"a\",\"0549\"],[\"b\",\"0457\"],[\"a\",\"0532\"],[\"a\",\"0621\"],[\"b\",\"0540\"]]"));
    }

}
