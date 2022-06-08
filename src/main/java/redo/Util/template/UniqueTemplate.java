package redo.Util.template;

import java.util.function.BiFunction;

public class UniqueTemplate {

    public int unique(int[] array) {
        int now = 0, mid = 0;

        while (++mid != array.length) {
            if (array[now] != array[mid]) {
                array[++now] = array[mid];
            }
        }

        return now + 1;
    }

    public <T> int unique(T[] array) {
        int now = 0, mid = 0;

        while (++mid != array.length) {
            if (array[now] != array[mid]) {
                array[++now] = array[mid];
            }
        }

        return now + 1;
    }

    public <T> int unique(T[] array, BiFunction<T, T, Boolean> isEquals) {
        int now = 0, mid = 0;

        while (++mid != array.length) {
            if (!isEquals.apply(array[now], array[mid])) {
                array[++now] = array[mid];
            }
        }

        return now + 1;
    }

}
