package test;

import java.util.ArrayList;
import java.util.List;

public class T1 {
	
	public static void main(String[] args) {
		{
			long a=System.currentTimeMillis();
			
			for(int i=0;i<1000;i++){
				fizzBuzz(1000);
			}
			
			System.out.println(System.currentTimeMillis()-a);
		}
		{
			long a=System.currentTimeMillis();
			
			for(int i=0;i<1000;i++){
				fizzBuzz1(1000);
			}
			
			System.out.println(System.currentTimeMillis()-a);
		}
		{
			long a=System.currentTimeMillis();
			
			for(int i=0;i<1000000;i++){
				fizzBuzz(1000);
			}
			
			System.out.println(System.currentTimeMillis()-a);
		}
		{
			long a=System.currentTimeMillis();
			
			for(int i=0;i<1000000;i++){
				fizzBuzz1(1000);
			}
			
			System.out.println(System.currentTimeMillis()-a);
		}
	}

	public static List<String> fizzBuzz(int n) {
    	List<String> ans=new ArrayList<>(n);
    	
        for(int i=1;i<=n;i++){
        	if(i%3==0&&i%5==0){
        		ans.add("FizzBuzz");
        	}else if(i%3==0){
        		ans.add("Fizz");
        	}else if(i%5==0){
        		ans.add("Buzz");
        	}else{
        		ans.add(Integer.toString(i));
        	}
        }
        
        return ans;
    }
	
	public static List<String> fizzBuzz1(int n) {
    	List<String> ans=new ArrayList<>(n);
    	
        for(int i=1;i<=n;i++){
        	int mod3=i%3;
        	int mod5=i%5;
        	
        	if(mod3==0&&mod5==0){
        		ans.add("FizzBuzz");
        	}else if(mod3==0){
        		ans.add("Fizz");
        	}else if(mod5==0){
        		ans.add("Buzz");
        	}else{
        		ans.add(Integer.toString(i));
        	}
        }
        
        return ans;
    }
	
}
