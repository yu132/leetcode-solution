package redo.p0900_0999;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**  
 * @ClassName: P981  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月20日  
 *  
 */
public class P981 {

    static//

    class TimeMap {

        Map<String, TreeMap<Integer, String>> map = new HashMap<>();

        /** Initialize your data structure here. */
        public TimeMap() {}

        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, (x) -> new TreeMap<>()).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            Map.Entry<Integer, String> entry = map.computeIfAbsent(key, (x) -> new TreeMap<>()).floorEntry(timestamp);
            if (entry == null) {
                return "";
            }
            return entry.getValue();
        }

    }



}
