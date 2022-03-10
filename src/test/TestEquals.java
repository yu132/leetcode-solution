package test;

public class TestEquals {

    public static void main(String[] args) {

        // int[] array = new int[10];

        // array[f1(2)] = array[f1(3)] = f2(array[4], array[5]);

        double a = 1.0;

        double b = 0.05;

        double c = 0;

        for (int i = 0; i < 20; ++i) {
            c += b;
        }

        System.out.println(a);
        System.out.println(c);

        System.out.println(Double.compare(a, c));
    }

    public static int f1(int i) {
        System.out.println("f1 " + i);
        return i;
    }

    public static int f2(int a, int b) {
        System.out.println("f2");
        return a + b;
    }

}
