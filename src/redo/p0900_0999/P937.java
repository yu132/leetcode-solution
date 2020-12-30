package redo.p0900_0999;

import java.util.Arrays;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P937  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月25日  
 *  
 */
public class P937 {

    class Solution {
        public String[] reorderLogFiles(String[] logs) {
            Log[] logObjects = new Log[logs.length];
            Pattern p = Pattern.compile("[\\s0-9]*");
            for (int i = 0; i < logs.length; ++i) {
                int index = logs[i].indexOf(' ');
                Log log = new Log();
                log.id = logs[i].substring(0, index);
                log.content = logs[i].substring(index + 1);
                log.isNumber = p.matcher(log.content).matches();
                logObjects[i] = log;
            }
            Arrays.sort(logObjects);
            for (int i = 0; i < logs.length; ++i) {
                logs[i] = logObjects[i].id + " " + logObjects[i].content;
            }
            return logs;
        }

        private class Log implements Comparable<Log> {
            String id;
            String content;
            boolean isNumber;

            @Override
            public int compareTo(Log o) {
                if (isNumber && !o.isNumber) {
                    return 1;
                } else if (!isNumber && o.isNumber) {
                    return -1;
                } else if (isNumber && o.isNumber) {
                    return 0;
                } else {
                    int comp = content.compareTo(o.content);
                    if (comp == 0) {
                        return id.compareTo(o.id);
                    }
                    return comp;
                }
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new String[] {"g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7"},
            s.reorderLogFiles(new String[] {"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"}));
    }

}
