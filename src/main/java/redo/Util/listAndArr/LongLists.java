package redo.Util.listAndArr;

import java.util.ArrayList;
import java.util.List;

public class LongLists {

    //将相等的数字合并为一个区间范围，返回值中内部数组结构为(start,end(不包括)，val)
    List<List<Long>> partitionIntervalEquals(long[] arr, int start, int end) {
        List<List<Long>> ans = new ArrayList<>();
        long val = arr[start], len = 0, last = start;
        for (int i = start; i < end; ++i) {
            if (val == arr[i]) {
                ++len;
            } else {
                final long temp = i;
                final long ll = last;
                ans.add(new ArrayList<Long>() {{
                    add(ll);
                    add(temp);
                    add(val);
                }});
                last = i;
                len = 1;
            }
        }
        final long temp = end;
        final long ll = last;
        ans.add(new ArrayList<Long>() {{
            add(ll);
            add(temp);
            add(val);
        }});
        return ans;
    }

}
