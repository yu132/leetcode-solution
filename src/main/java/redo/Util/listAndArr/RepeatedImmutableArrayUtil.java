package redo.Util.listAndArr;

public class RepeatedImmutableArrayUtil {

    class RepeatedImmutableArray<T> {
        T[] arr;

        public RepeatedImmutableArray(T[] arr) {
            this.arr = arr;
        }

        T get(int index) {
            return arr[index % arr.length];
        }
    }

}
