package redo.p2400_2499;

import java.util.Arrays;
import java.util.function.Function;

public class P2410 {

    class Solution {
        public int matchPlayersAndTrainers(int[] players, int[] trainers) {
            Arrays.sort(players);
            Arrays.sort(trainers);

            NextHelper helper = new NextHelper(trainers.length);

            int ans = 0;

            for (int player : players) {
                int low = binarySearchMin(0, trainers.length, mid -> trainers[mid] >= player);
                int next = helper.findNext(low);
                if (next == -1) {
                    break;
                }
                helper.use(next);
                ++ans;
            }
            return ans;
        }

        public int binarySearchMin(int low, int high, Function<Integer, Boolean> judge) {
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (judge.apply(mid)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        class NextHelper {
            int[] next;

            NextHelper(int len) {
                next = new int[len];
                Arrays.setAll(next, (x) -> x);
            }

            int findNext(int index) {
                if (index >= next.length) {
                    return -1;
                }
                if (next[index] == index) {
                    return index;
                } else {
                    return next[index] = findNext(next[index]);
                }
            }

            void use(int index) {
                next[index] = index + 1;
            }
        }
    }

}
