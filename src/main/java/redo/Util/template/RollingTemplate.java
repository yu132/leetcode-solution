package redo.Util.template;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class RollingTemplate {

    class RollingHelper<T> {

        T[] rollingArr = (T[]) new Object[2];

        int roll = 1;

        public RollingHelper(Supplier<T> constructor) {
            rollingArr[0] = constructor.get();
            rollingArr[1] = constructor.get();
        }

        public RollingHelper(Supplier<T> constructor, Consumer<T> init) {
            this(constructor);
            init.accept(rollingArr[0]);
        }

        T now() {
            return rollingArr[roll];
        }

        T last() {
            return rollingArr[roll ^ 1];
        }

        void toNext() {
            roll ^= 1;
        }
    }

}
