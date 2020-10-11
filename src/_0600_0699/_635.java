package _0600_0699;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**  
 * @ClassName: _635  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月15日  
 *  
 */
public class _635 {

    class LogSystem {

        class Node {
            long timestamp;
            int index;

            public Node(long timestamp, int index) {
                super();
                this.timestamp = timestamp;
                this.index     = index;
            }
        }

        private ArrayList<Node> list = new ArrayList<>();

        private SimpleDateFormat formatter = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");

        private Comparator<Node> comp = (a, b) -> {
            return Long.compare(a.timestamp, b.timestamp);
        };

        public LogSystem() {}

        public void put(int id, String timestamp) {
            try {
                Node node  = new Node(formatter.parse(timestamp).getTime(), id);

                int  index = Collections.binarySearch(list, node, comp);

                if (index < 0) {
                    index = -index - 1;
                }

                list.add(index, node);

            } catch (ParseException e) {
            }
        }

        public List<Integer> retrieve(String s, String e, String gra) {

            try {
                long          ss     = floor(formatter.parse(s).getTime(), gra);
                long          ee     = ceil(formatter.parse(e).getTime(), gra);

                int           lbound = lowerBound(list, 0, list.size(), new Node(ss, 0), comp);
                int           ubound = lowerBound(list, 0, list.size(), new Node(ee, 0), comp);

                List<Node>    temp   = list.subList(lbound, ubound);

                List<Integer> ans    = new ArrayList<>();

                for (Node each : temp) {
                    ans.add(each.index);
                }

                return ans;

            } catch (ParseException e1) {
                return null;
            }

        }

        public <E> int lowerBound(List<E> list, int from, int size, E key, Comparator<E> comp) {
            int first = from, middle;
            int half, len;
            len = size;

            while (len > 0) {
                half   = len >> 1;
                middle = first + half;
                if (comp.compare(list.get(middle), key) < 0) {
                    first = middle + 1;
                    len   = len - half - 1; // 在右边子序列中查找
                } else {
                    len = half; // 在左边子序列（包含middle）中查找
                }
            }
            return first;
        }

        public long floor(long time, String type) {
            Date     d = new Date(time);
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            switch (type.toLowerCase()) {
                case "year":
                    c.set(Calendar.MONTH, 0);
                case "month":
                    c.set(Calendar.DATE, 1);
                case "day":
                    c.set(Calendar.HOUR_OF_DAY, 0);
                case "hour":
                    c.set(Calendar.MINUTE, 0);
                case "minute":
                    c.set(Calendar.SECOND, 0);
            }
            System.out.println(c.getTime());
            return c.getTimeInMillis();
        }

        public long ceil(long time, String type) {
            Date     d = new Date(time);
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            switch (type.toLowerCase()) {
                case "year":
                    c.set(Calendar.YEAR, c.get(Calendar.YEAR) + 1);
                    c.set(Calendar.MONTH, 0);
                    c.set(Calendar.DATE, 1);
                    c.set(Calendar.HOUR_OF_DAY, 0);
                    c.set(Calendar.MINUTE, 0);
                    c.set(Calendar.SECOND, 0);
                    break;
                case "month":
                    c.set(Calendar.MONTH, c.get(Calendar.MONTH) + 1);
                    c.set(Calendar.DATE, 1);
                    c.set(Calendar.HOUR_OF_DAY, 0);
                    c.set(Calendar.MINUTE, 0);
                    c.set(Calendar.SECOND, 0);
                    break;
                case "day":
                    c.set(Calendar.DATE, c.get(Calendar.DATE) + 1);
                    c.set(Calendar.HOUR_OF_DAY, 0);
                    c.set(Calendar.MINUTE, 0);
                    c.set(Calendar.SECOND, 0);
                    break;
                case "hour":
                    c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) + 1);
                    c.set(Calendar.MINUTE, 0);
                    c.set(Calendar.SECOND, 0);
                    break;
                case "minute":
                    c.set(Calendar.MINUTE, c.get(Calendar.MINUTE) + 1);
                    c.set(Calendar.SECOND, 0);
                    break;
                case "second":
                    c.set(Calendar.SECOND, c.get(Calendar.SECOND) + 1);
                    break;
            }
            System.out.println(c.getTime());
            return c.getTimeInMillis();
        }
    }

    public static void main(String[] args) throws ParseException {
        LogSystem l = new _635().new LogSystem();
        // System.out.println(l.floor(l.formatter.parse("2016:01:01:01:01:01").getTime(), "month"));
        // System.out.println(l.formatter.parse("2016:01:01:00:00:00").getTime());
        // System.out.println(l.floor(l.formatter.parse("2000:01:03:12:26:35").getTime(), "month"));
        // System.out.println(l.formatter.parse("2000:01:01:00:00:00").getTime());

        l.put(1, "2017:01:01:23:59:59");
        l.put(2, "2017:01:01:22:59:59");
        l.put(3, "2016:01:01:00:00:00");

        System.out.println(l.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year"));
        System.out.println(l.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour"));
    }

}
