package redo.p2700_2799;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class P2785 {

    static//

    class Solution {
        public String sortVowels(String s) {
            char[] chs = s.toCharArray();
            Sortable<Character> sortable = new Sortable<Character>() {

                Map<Integer, Integer> indexMap = new HashMap<>();

                {
                    for (int i = 0; i < chs.length; ++i) {
                        if (isVowel(chs[i])) {
                            indexMap.put(indexMap.size(), i);
                        }
                    }
                }

                @Override
                public int size() {
                    return indexMap.size();
                }

                @Override
                public Character get(int index) {
                    return chs[indexMap.get(index)];
                }

                @Override
                public void set(int index, Character val) {
                    chs[indexMap.get(index)] = val;
                }
            };
            sort(sortable, Character::compare);
            return new String(chs);
        }

        public boolean isVowel(char ch) {
            return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                    || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
        }

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

}
