package redo.Util.template;

public class IndexTemplate {

    class Index<T> {
        T[] arr;

        public Index(T[] arr) {
            this.arr = arr;
        }

        int index(T item) {
            for (int i = 0; i < arr.length; ++i) {
                if (item == arr[i]) {
                    return i;
                }
            }
            return arr.length;
        }
    }

}
