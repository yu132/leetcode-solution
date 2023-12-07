package redo.Util.newcommutil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class SortFastUtil {


    interface Sortable<T> {
        int size();

        T get(int index);

        void set(int index, T val);
    }

    <T> void sort(Sortable<T> sortable, Comparator<T> comparator) {
        Integer[] indexes = new Integer[sortable.size()];
        Arrays.setAll(indexes, x -> x);
        Arrays.sort(indexes, Comparator.comparing(sortable::get, comparator));
        HashMap<Integer, T> tempMap = new HashMap<>();
        for (int i = 0; i < indexes.length; ++i) {
            tempMap.put(i, sortable.get(i));
            sortable.set(i, tempMap.getOrDefault(indexes[i], sortable.get(indexes[i])));
        }
    }


}
