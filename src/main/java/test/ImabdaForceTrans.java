package test;

import java.io.Serializable;
import java.util.function.Function;

public class ImabdaForceTrans {

    interface InterfaceA {

    }

    interface InterfaceB {
        default void a() {
            System.out.println("hhhh");
        }
    }

    class ClassA<T, R> {
        public void b() {
            System.out.println("aaaaa");
        }
    }

    static Function<Integer, Integer> funA() {
        return (Function<Integer, Integer> & InterfaceA & Serializable & InterfaceB) x -> x;
    }

    static Function<Integer, Integer> funB() {
        return x -> x;
    }

    public static void main(String[] args) {
        Function<Integer, Integer> a = funA(), b = funB();
        System.out.println(a instanceof InterfaceA);
        System.out.println(b instanceof InterfaceA);
        System.out.println(a instanceof Function);
        System.out.println(b instanceof Function);
        System.out.println(a.getClass().getGenericSuperclass());
        ((InterfaceB) funA()).a();
        ((ClassA<Integer, Integer>) funA()).b();
        ;
    }

}
