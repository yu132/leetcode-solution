package test;

public class T2527 {

    public static void main(String[] args) {
        int[] a = new int[]{15, 45, 20, 2, 34, 35, 5, 44, 32, 30};
        int temp = 0;
        for (int num : a) {
            temp ^= num;
        }
        System.out.println(temp);
    }

}
