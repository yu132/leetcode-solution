package old._0800_0899;

import java.util.TreeSet;

/**  
 * @ClassName: _855  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月7日  
 *  
 */
public class _855 {

    class ExamRoom {

        TreeSet<Integer> set = new TreeSet<>();

        int N;

        public ExamRoom(int N) {
            set.add(-1);
            set.add(N);
            this.N = N;
        }

        public int seat() {
            int prev = set.first();
            int low  = 0, high = 0, max = 0;
            for (int each : set) {
                int len;
                if (prev == -1 || each == N) {
                    len = each - prev - 1;
                } else {
                    len = (each - prev) / 2;
                }
                if (len > max) {
                    max  = len;
                    low  = prev;
                    high = each;
                }
                prev = each;
            }
            if (low == -1)

            {
                set.add(0);
                return 0;
            } else if (high == N) {
                set.add(N - 1);
                return N - 1;
            } else {
                int index = (low + high) >>> 1;
                set.add(index);
                return index;
            }
        }

        public void leave(int p) {
            set.remove(p);
        }

    }

    public static void main(String[] args) {
        ExamRoom ex = new _855().new ExamRoom(8);
        System.out.println(ex.seat());
        System.out.println(ex.seat());
        System.out.println(ex.seat());
        ex.leave(0);
        ex.leave(7);
        System.out.println(ex.seat());
        System.out.println(ex.seat());

        System.out.println(ex.seat());
        System.out.println(ex.seat());
        System.out.println(ex.seat());
        System.out.println(ex.seat());
        System.out.println(ex.seat());
    }
}
