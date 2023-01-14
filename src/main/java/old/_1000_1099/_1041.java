package old._1000_1099;

public class _1041 {
	
	class Solution {
		public boolean isRobotBounded(String instructions) {
			
			int[]	direction	= { 0, 1, 1, 0, 0, -1, -1, 0 };
			
			int		dirIndex	= 0;
			int		x			= 0;
			int		y			= 0;
			
			for (char each : instructions.toCharArray()) {
				switch (each) {
					case 'G':
						x += direction[dirIndex * 2];
						y += direction[dirIndex * 2 + 1];
						break;
					case 'L':
						dirIndex = (dirIndex + 3) % 4;
						break;
					case 'R':
						dirIndex = (dirIndex + 1) % 4;
						break;
				}
			}
			
			return (x == 0 && y == 0) || dirIndex != 0;
		}
	}
	
}
