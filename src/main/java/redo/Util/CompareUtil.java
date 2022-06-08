package redo.Util;

import java.util.Comparator;

public class CompareUtil {

    static class CompareHelper<T> {

        Comparator<T> comparator;

        public CompareHelper(Comparator<T> comparator) {
            this.comparator = comparator;
        }

        static <T> CompareHelper<T> with(Comparator<T> comparator) {
            return new CompareHelper<>(comparator);
        }

        T min(T... elements) {
            T min = elements[0];
            for (int i = 1; i < elements.length; ++i) {
                if (comparator.compare(min, elements[i]) > 0) {
                    min = elements[i];
                }
            }
            return min;
        }

    }


}
