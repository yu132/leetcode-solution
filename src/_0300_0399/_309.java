package _0300_0399;

public class _309 {

	public int maxProfit(int[] prices) {
        
		if(prices.length==0)
			return 0;
		
		int count=0;
		
		int l1=0;
		int l2=0;
		int l3=0;
		
		for(int i=1;i<prices.length;i++){
			
			System.out.println(l1+" "+l2+" "+l3);
			
//			if(prices[i]<prices[l1]){
//				l1=i;
//				l2=i;
//				continue;
//			}
			if(prices[i]>=prices[l2]){
				l2=i;
				continue;
			}else{
				l3=i;
				if(l3==prices.length-1){
					count+=prices[l2]-prices[l1];
					l1=l3;
					l2=l3;
					break;
				}
				if(l2==0){
					l1=l3;
					l2=l3;
					continue;
				}
				if(prices[l2]-prices[l2-1]<prices[l3+1]-prices[l3]){
					count+=prices[l2-1]-prices[l1];
					l1=l3;
					l2=l3;
				}else{
					count+=prices[l2]-prices[l1];
					l1=l3+1;
					l2=l3+1;
				}
			}
			
		}
		if(prices[l2]-prices[l1]>0){
			count+=prices[l2]-prices[l1];
		}
		return count;
    }
	
	
	public static void main(String[] args) {
		//int[] a={1,2,3,0,2};
		int[] a={6,1,3,2,4,7};
		System.out.println(new _309().maxProfit(a));
	}
}
