package old._0100_0199;

import java.util.ArrayList;
import java.util.HashMap;

/**  
 * @ClassName: _170  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月26日  
 *  
 */
public class _170 {

    class TwoSum {

        private ArrayList<Integer> list = new ArrayList<>();

        private HashMap<Integer, Integer> map = new HashMap<>();

        /** Initialize your data structure here. */
        public TwoSum() {}

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            list.add(number);
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            for (int i = 0; i < list.size(); ++i) {
                if (value == list.get(i) * 2) {
                    Integer val = map.get(list.get(i));
                    if (val != null && val >= 2) {
                        return true;
                    }
                } else {
                    if (map.containsKey(value - list.get(i))) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

}
