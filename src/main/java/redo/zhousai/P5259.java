package redo.zhousai;

public class P5259 {

    class Solution {
        public double calculateTax(int[][] brackets, int income) {
            int index = 0;
            double tax = 0;
            while (income > 0) {
                if (index == 0) {
                    tax += (double) Math.min(brackets[index][0], income) * brackets[index][1] / 100;
                    income -= brackets[index][0];
                } else {
                    int money = brackets[index][0] - brackets[index - 1][0];
                    tax += (double) Math.min(money, income) * brackets[index][1] / 100;
                    income -= money;
                }
                ++index;
            }
            return tax;
        }
    }

}
