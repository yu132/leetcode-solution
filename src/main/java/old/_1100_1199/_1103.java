package old._1100_1199;

public class _1103 {
	
	class Solution {
		public int[] distributeCandies(int candies, int num_people) {
			
			int		num		= 1;
			
			int[]	each	= new int[num_people];
			
			while (num <= candies) {
				each[(num - 1) % num_people]	+= num;
				candies							-= num;
				++num;
			}
			
			each[(num - 1) % num_people] += candies;
			
			return each;
		}
	}
	
}
