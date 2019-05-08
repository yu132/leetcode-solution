package test;

public class CharAt_ToCharArray {
	public static void test() {  
	    
	    StringBuilder sb=new StringBuilder();
	    for(int i = 0; i < 100000; i++) {  
	       sb.append("a");
	    }  
	    
	    String s=sb.toString(); 
	    
	    char[] cs = s.toCharArray(); 
	    long start1 = System.currentTimeMillis();  
	    for(int x=0;x<100000000;x++)
		    for(int i=0;i<cs.length;i++) { 
		    	char c = cs[i];  
		   //     System.out.println(c); // 需要输入语句进入循环  
		    }  
	    long end1 = System.currentTimeMillis(); 
	    
	    long start2 = System.currentTimeMillis(); 
	    
	    for(int x=0;x<100000000;x++)
		    for(int i = 0; i < s.length(); i++) {  
		        char c = s.charAt(i); 
		        
		  //      System.out.println(c);  
		    }  
	    long end2 = System.currentTimeMillis();  
	    
	      
	    System.out.println(end1 - start1);  
	    System.out.println(end2 - start2);  
	} 
	
	public static void main(String[] args) {
		test();
	}
}
