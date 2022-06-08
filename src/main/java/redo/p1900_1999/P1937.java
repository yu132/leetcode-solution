package redo.p1900_1999;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class P1937 {

    class Solution {
        public long maxPoints(int[][] points) {
            int m = points.length, n = points[0].length;
            RollingHelper<long[]> rollingHelper = new RollingHelper<>(() -> new long[n], arr -> {
                for (int i = 0; i < n; ++i) {
                    arr[i] = points[0][i];
                }
            });
            for (int i = 1; i < m; ++i, rollingHelper.toNext()) {
                long best = Long.MIN_VALUE;
                for (int j = 0; j < n; ++j) {
                    best = Math.max(best, rollingHelper.last()[j] + j);
                    rollingHelper.now()[j] = Math.max(rollingHelper.now()[j], best + points[i][j] - j);
                }
                best = Long.MIN_VALUE;
                for (int j = n - 1; j >= 0; --j) {
                    best = Math.max(best, rollingHelper.last()[j] - j);
                    rollingHelper.now()[j] = Math.max(rollingHelper.now()[j], best + points[i][j] + j);
                }
            }

            long max = 0;
            for (int i = 0; i < n; ++i) {
                max = Math.max(max, rollingHelper.last()[i]);
            }
            return max;
        }

        class RollingHelper<T> {

            T[] rollingArr = (T[]) new Object[2];

            int roll = 1;

            public RollingHelper(Supplier<T> constructor) {
                rollingArr[0] = constructor.get();
                rollingArr[1] = constructor.get();
            }

            public RollingHelper(Supplier<T> constructor, Consumer<T> init) {
                this(constructor);
                init.accept(rollingArr[0]);
            }

            T now() {
                return rollingArr[roll];
            }

            T last() {
                return rollingArr[roll ^ 1];
            }

            void toNext() {
                roll ^= 1;
            }
        }
    }

}
