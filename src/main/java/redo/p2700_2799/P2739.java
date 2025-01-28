package redo.p2700_2799;

public class P2739 {

    class Solution {
        public int distanceTraveled(int mainTank, int additionalTank) {
            if (mainTank < 5) {
                return mainTank * 10;
            }
            return (mainTank + Math.min((mainTank - 1) / 4, additionalTank)) * 10;
        }
    }

}
