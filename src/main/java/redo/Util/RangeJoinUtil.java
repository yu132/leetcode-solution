package redo.Util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class RangeJoinUtil {

    class RangeJoin {
        Map<Integer, RangeJoin.Range> leftMap = new HashMap<>(), rightMap = new HashMap<>();

        Set<RangeJoin.Range> allRange = new HashSet<>();

        Function<Integer, Integer> prev, next;

        public RangeJoin(Function<Integer, Integer> prev, Function<Integer, Integer> next) {
            this.prev = prev;
            this.next = next;
        }

        RangeJoin.Range EMPTY = new RangeJoin.Range(-1, -1);

        class Range {
            int left;
            int right;

            public int length() {
                return right - left;
            }

            public Range(int left, int right) {
                this.left = left;
                this.right = right;
            }

            void merge(RangeJoin.Range r) {
                if (EMPTY == r) {
                    return;
                }
                this.removeSelf();
                r.removeSelf();
                left = Math.min(left, r.left);
                right = Math.max(right, r.right);
                this.addSelf();
            }

            void removeSelf() {
                leftMap.remove(left);
                rightMap.remove(right);
                allRange.remove(this);
            }

            void addSelf() {
                leftMap.put(left, this);
                rightMap.put(right, this);
                allRange.add(this);
            }
        }

        void join(int left, int right) {
            RangeJoin.Range now = new RangeJoin.Range(left, right);
            now.addSelf();
            now.merge(leftMap.getOrDefault(prev.apply(left), EMPTY));
            now.merge(leftMap.getOrDefault(next.apply(right), EMPTY));
        }
    }

}
