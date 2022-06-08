package redo.p2100_2199;

public class P2166 {

    class Bitset {

        boolean[] bits;

        boolean reverse = false;
        int count1 = 0;

        public Bitset(int size) {
            bits = new boolean[size];
        }

        public void fix(int idx) {
            if (bits[idx] == reverse) {
                ++count1;
                bits[idx] = !reverse;
            }
        }

        public void unfix(int idx) {
            if (bits[idx] != reverse) {
                --count1;
                bits[idx] = reverse;
            }
        }

        public void flip() {
            reverse = !reverse;
            count1 = bits.length - count1;
        }

        public boolean all() {
            return count1 == bits.length;
        }

        public boolean one() {
            return count1 > 0;
        }

        public int count() {
            return count1;
        }

        public String toString() {
            StringBuilder buf = new StringBuilder(bits.length);
            for (boolean bit : bits) {
                buf.append((bit ^ reverse) ? '1' : '0');
            }
            return buf.toString();
        }
    }

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */

}
