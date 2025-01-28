package redo.p2600_2699;

public class P2660 {

    class Solution {
        public int isWinner(int[] player1, int[] player2) {
            int p1 = count(player1);
            int p2 = count(player2);
            if (p1 > p2) {
                return 1;
            } else if (p1 < p2) {
                return 2;
            } else {
                return 0;
            }
        }

        int count(int[] play) {
            int count = 0;
            int n1 = 0;
            int n2 = 0;
            for (int j : play) {
                if (n1 == 10 || n2 == 10) {
                    count += 2 * j;
                } else {
                    count += j;
                }
                n1 = n2;
                n2 = j;
            }
            return count;
        }
    }

}
