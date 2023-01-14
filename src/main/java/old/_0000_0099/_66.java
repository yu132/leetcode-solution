package old._0000_0099;

public class _66 {
	
	public int[] plusOne(int[] digits) {
		int i;
		for(i=digits.length-1;i>=0;i--){
			if(++digits[i]==10)
				digits[i]=0;
			else
				break;
		}
		
		if(i!=-1)
			return digits;
		else{
			int[] temp=new int[digits.length+1];
			temp[0]=1;
			for(int j=0;j<digits.length;j++){
				temp[j+1]=digits[j];
			}
			return temp;
		}
    }
	
	public static void printArray(int[] array){
		System.out.print("{ ");
		for(int i=0;i<array.length-1;i++)
			System.out.print(array[i]+", ");
		System.out.println(array[array.length-1]+" }");
	}
	
	public static void main(String[] args) {
		int[] a={9,9,9,9};
		printArray(new _66().plusOne(a));
	}

}
