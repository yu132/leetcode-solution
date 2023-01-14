package redo.Util.ag.array.minSortedSwapTime;

import java.util.*;

public class MinSortedSwapTime {

    /**
     * 任意两两交换最少的交换次数
     *
     * @param list
     * @return
     */
    int minSwapAny(List<Integer> list) {
        List<Integer> sorted = new ArrayList<>(list);
        Collections.sort(sorted);

        Map<Integer, Integer> indexSorted = new HashMap<>();
        for (int i = 0; i < sorted.size(); ++i) {
            indexSorted.put(sorted.get(i), i);
        }

        int count = 0;
        for (int i = 0; i < list.size(); ++i) {
            int val = list.get(i);
            if (indexSorted.containsKey(val)) {
                ++count;
            }
            while (indexSorted.containsKey(val)) {
                val = list.get(indexSorted.remove(val));
            }
        }

        return list.size() - count;
    }

   
}
