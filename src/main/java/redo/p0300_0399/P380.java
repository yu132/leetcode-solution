package redo.p0300_0399;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**  
 * @ClassName: P380  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月15日  
 *  
 */
public class P380 {

    class RandomizedSet {

        Map<Integer, Integer> indexes = new HashMap<>();

        List<Integer> list = new ArrayList<>();

        ThreadLocalRandom r = ThreadLocalRandom.current();

        /** Initialize your data structure here. */
        public RandomizedSet() {}

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (indexes.containsKey(val)) {
                return false;
            }
            int index = list.size();
            indexes.put(val, index);
            list.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!indexes.containsKey(val)) {
                return false;
            }
            int index = indexes.remove(val);
            int toSwapVal = list.get(list.size() - 1);
            if (index != list.size() - 1) {
                list.set(index, toSwapVal);
                indexes.put(toSwapVal, index);
            }
            list.remove(list.size() - 1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(r.nextInt(list.size()));
        }
    }

}
