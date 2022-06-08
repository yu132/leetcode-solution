package redo.p2100_2199;

import java.util.ArrayList;
import java.util.List;

public class P2125 {

    class Solution {
        public int numberOfBeams(String[] bank) {
            List<Integer> list = new ArrayList<>();
            for (String str : bank) {
                int count = 0;
                for (char ch : str.toCharArray()) {
                    if (ch == '1') {
                        ++count;
                    }
                }
                if (count > 0) {
                    list.add(count);
                }
            }
            int ans = 0;
            for (int i = 1; i < list.size(); ++i) {
                ans += list.get(i - 1) * list.get(i);
            }
            return ans;
        }
    }

}
