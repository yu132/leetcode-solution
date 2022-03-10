package redo.Util.ag.helpeutils.pq;

public class PQHelper {

    class IntWithIndex implements Comparable<Integer> {
        int value;
        int index;

        public IntWithIndex(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Integer o) {
            return Integer.compare(value, o);
        }
    }

}
