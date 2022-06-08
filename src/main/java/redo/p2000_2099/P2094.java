package redo.p2000_2099;

import java.util.ArrayList;
import java.util.List;

public class P2094 {

    class Solution {
        public int[] findEvenNumbers(int[] digits) {
            int[] counter = new int[10];
            for (int digit : digits) {
                ++counter[digit];
            }
            List<Integer> ans = new ArrayList<>();

            for (int i = 1; i < 10; ++i) {
                if (counter[i] == 0) {
                    continue;
                }
                --counter[i];
                for (int j = 0; j < 10; ++j) {
                    if (counter[j] == 0) {
                        continue;
                    }
                    --counter[j];
                    for (int k = 0; k < 10; k += 2) {
                        if (counter[k] == 0) {
                            continue;
                        }
                        ans.add(i * 100 + j * 10 + k);
                    }
                    ++counter[j];
                }
                ++counter[i];
            }

            return toIntArray(ans);
        }

        int[] toIntArray(List<Integer> list) {
            int[] arr = new int[list.size()];
            for (int i = 0; i < arr.length; ++i) {
                arr[i] = list.get(i);
            }
            return arr;
        }
    }

}
