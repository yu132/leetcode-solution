package _0000_0099;

import java.util.ArrayList;

public class _12_intToRoman {
	public String intToRoman(int num) {
		
		int index=0;
		
		StringBuilder sb=new StringBuilder(100);
		
		ArrayList<String> l=new ArrayList<>();
		
		while(num!=0){
			int digit=num%10;
			num/=10;
			
			l.add(digitDeal(digit,index));
			
			index++;
		}
		
		for(int i=l.size()-1;i>=0;i--)
			sb.append(l.get(i));
		
		return sb.toString();
    }
	
	public String digitDeal(int digit,int index){
		if(index==0){
			switch(digit){
			case 0:
				return "";
			case 1:
				return "I";
			case 2:
				return "II";
			case 3:
				return "III";
			case 4:
				return "IV";
			case 5:
				return "V";
			case 6:
				return "VI";
			case 7:
				return "VII";
			case 8:
				return "VIII";
			case 9:
				return "IX";
			}
		}else if(index==1){
			switch(digit){
			case 0:
				return "";
			case 1:
				return "X";
			case 2:
				return "XX";
			case 3:
				return "XXX";
			case 4:
				return "XL";
			case 5:
				return "L";
			case 6:
				return "LX";
			case 7:
				return "LXX";
			case 8:
				return "LXXX";
			case 9:
				return "XC";
			}
		}else if(index==2){
			switch(digit){
			case 0:
				return "";
			case 1:
				return "C";
			case 2:
				return "CC";
			case 3:
				return "CCC";
			case 4:
				return "CD";
			case 5:
				return "D";
			case 6:
				return "DC";
			case 7:
				return "DCC";
			case 8:
				return "DCCC";
			case 9:
				return "CM";
			}
		}else if(index==3){
			switch(digit){
			case 0:
				return "";
			case 1:
				return "M";
			case 2:
				return "MM";
			case 3:
				return "MMM";
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(new _12_intToRoman().intToRoman(3999));
	}
}
