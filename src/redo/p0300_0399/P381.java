package redo.p0300_0399;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**  
 * @ClassName: P381  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月15日  
 *  
 */
public class P381 {

    class RandomizedCollection {

        Map<Integer, Set<Integer>> indexes = new HashMap<>();

        List<Integer> list = new ArrayList<>();

        ThreadLocalRandom r = ThreadLocalRandom.current();

        /** Initialize your data structure here. */
        public RandomizedCollection() {}

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            int index = list.size();
            Set<Integer> indexesOfVal =
                indexes.computeIfAbsent(val, (x) -> new HashSet<>());
            indexesOfVal.add(index);
            list.add(val);
            return indexesOfVal.size() == 1;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if (!indexes.containsKey(val)) {
                return false;
            }
            Set<Integer> indexesOfVal = indexes.get(val);

            int index = indexesOfVal.iterator().next();

            indexesOfVal.remove(index);

            if (indexesOfVal.size() == 0) {
                indexes.remove(val);
            }

            if (index != list.size() - 1) {
                int toSwapVal = list.get(list.size() - 1);
                list.set(index, toSwapVal);
                Set<Integer> indexesOfToSwapVal = indexes.get(toSwapVal);
                indexesOfToSwapVal.remove(list.size() - 1);
                indexesOfToSwapVal.add(index);
            }

            list.remove(list.size() - 1);
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return list.get(r.nextInt(list.size()));
        }
    }

}
