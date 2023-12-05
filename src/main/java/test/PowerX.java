package test;

import java.util.ArrayList;
import java.util.List;

public class PowerX {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        long base = 1;
        int exp = 5;
        while (base < Integer.MAX_VALUE) {
            list.add((int) base);
            base *= exp;
        }
        System.out.println(list);
    }

}
