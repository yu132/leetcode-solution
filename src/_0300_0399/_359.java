package _0300_0399;

import java.util.HashMap;

/**  
 * @ClassName: _359  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月27日  
 *  
 */
public class _359 {

    class Logger {

        private HashMap<String, Integer> map = new HashMap<>();

        /** Initialize your data structure here. */
        public Logger() {}

        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
            If this method returns false, the message will not be printed.
            The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
            if (map.containsKey(message)) {
                if (map.get(message) > timestamp - 10) {
                    return false;
                }
            }
            map.put(message, timestamp);
            return true;
        }
    }

    public static void main(String[] args) {
        Logger l = new _359().new Logger();
        System.out.println(l.shouldPrintMessage(1, "foo"));
        System.out.println(l.shouldPrintMessage(4, "foo"));
        System.out.println(l.shouldPrintMessage(11, "foo"));
    }

}
