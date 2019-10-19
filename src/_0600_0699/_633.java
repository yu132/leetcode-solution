package _0600_0699;

public class _633 {

//	public static void main(String[] args) {
//		
//		StringBuilder sb=new StringBuilder(10000);
//		
//		sb.append("new int[]{1");
//		
//		for(long i=2;;i++){
//			
//			long x=i*i;
//			
//			if(x>Integer.MAX_VALUE)
//				break;
//			
//			sb.append(",");
//			
//			sb.append(x);
//			
//			if(i%100==0)
//				sb.append("\n");
//		}
//		
//		sb.append("}");
//		
//		try (FileOutputStream fops = new FileOutputStream("a.txt")) {
//			fops.write(sb.toString().getBytes("utf-8"));
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
/*	v1
	class Solution {

	    public boolean judgeSquareSum(int c) {
	        int[] power=new int[(int)Math.sqrt(c)+1];
	        
	        for(int i=1;i<power.length;i++){
	        	power[i]=i*i;
	        }
	        
	        for(int i=0;i<power.length;i++){
	        	for(int j=power.length-1;j>=i;j--){
	        		if(c==power[i]+power[j])
	        			return true;
	        	}
	        }
	        
	        return false;
	    }
	}*/
	
	class Solution {
	    public boolean judgeSquareSum(int c) {
	        int a = 0, b = (int)Math.sqrt(c);
	        while(a <= b) {
	            int s = a * a + b * b;
	            if(s == c) {
	                return true;
	            } else if(s > c) {
	                b--;
	            } else {
	                a++;
	            }
	        }
	        return false;
	    }
	}
	
}
