package com.java.strings;

import java.util.HashMap;
import java.util.Map;

public class StringQ {

	private final Map<Character,String> encodeMap =new HashMap<Character,String>();
	private final Map<String,Character> decodeMap =new HashMap<String,Character>();

	private static final int encodeStrLen = 2;

	public StringQ(){
		encodeMap.put(' ', "%20");
		encodeMap.put('<', "%3E");
		encodeMap.put('>', "%3C");
		encodeMap.put('$', "%24");
		encodeMap.put(';', "%3B");
		encodeMap.put('+', "%2B");

		decodeMap.put("%20",' ');
		decodeMap.put("%3E",'<');
		decodeMap.put("%3C",'>');
		decodeMap.put("%24",'$');
		decodeMap.put("%3B",';');
		decodeMap.put("%2B",'+');
	}

	public static String encodeString(String str){

		//We can use character array for this.
		//WhiteSpace to be replace by %20

		int whiteSpaceCount = 0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i) == ' '){
				whiteSpaceCount++;
			}
		}
		int newLength = str.length() + whiteSpaceCount * encodeStrLen;
		char [] arr = new char[newLength];
		int index = 0;

		for(int i=0;i<str.length();i++){
			if(str.charAt(i) == ' '){
				arr[index] = '%';
				arr[index+1] = '2';
				arr[index+2] = '0';
				index = index + 3;
			}
			else{
				arr[index] = str.charAt(i);
				index ++;
			}
		}

		return new String(arr);
	}

	public  String encodeStringV1(String str) throws Exception{
		if(str == null || ("").equals(str)){
			throw new Exception();
		}
		//We can use character array for this.
		//WhiteSpace to be replace by %20
		int encodeStringCount = 0;
		for(int i=0;i<str.length();i++){
			if(encodeMap.get(str.charAt(i))!= null){
				encodeStringCount++;
			}
		}

		int newLength = str.length() + encodeStringCount * encodeStrLen;
		char [] arr = new char[newLength];
		int index = 0;
		String tempChar ;

		for(int i=0;i<str.length();i++){
			tempChar = encodeMap.get(str.charAt(i));
			if(tempChar != null){
				arr[index] = tempChar.charAt(0);
				arr[index+1] = tempChar.charAt(1);
				arr[index+2] = tempChar.charAt(2);
				index = index + 3;
			}
			else{
				arr[index] = str.charAt(i);
				index ++;
			}
		}

		return new String(arr);
	}


	public String decodeString(String str){

		StringBuilder strNew = new StringBuilder(str);

		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='%' && decodeMap.get(str.substring(i,i+3)) != null){
				strNew = shiftLeft(i,3,str,str.substring(i,i+3));
			}

		}
		return strNew.toString();
	}

	private StringBuilder shiftLeft(int index, int offset, String str, String pattern){
		StringBuilder newStr = new StringBuilder(str.substring(0,index) + decodeMap.get(pattern) + str.substring(index+offset));
		return newStr;
	}

	public static void main(String args[]){
		/*System.out.println(encodeString("abc de fg h"));
		System.out.println(encodeString("abc de fg h "));
		System.out.println(encodeString(" abc de fg h"));
		 */
		StringQ obj = new StringQ();
		try{
			/*	System.out.println(obj.encodeStringV1("ab c"));
			System.out.println(obj.encodeStringV1("ab c "));
			System.out.println(obj.encodeStringV1("ab>+c"));
			System.out.println(obj.encodeStringV1("<ab c>d$m o;kl"));
			System.out.println(obj.encodeStringV1(""));
			 */	obj.decode("%3Eabc%20g%46h%%20%");
			 obj.decode("abc%20gh");
		}catch(Exception e){

		}

	}



	public void decode(String str){

		char[] arr = str.toCharArray();
		int size = arr.length;
		for(int i=0;i<size;i++){
			if(arr[i] == '%' && /*To check for Limits*/i+2 <= size){
				String pattern = String.valueOf(arr[i]) + String.valueOf(arr[i+1]) + String.valueOf(arr[i+2]);
				if(decodeMap.get(pattern) !=null){
					arr[i] = decodeMap.get(pattern);
					for(int j = i+1;j<size -2;j++){
						arr[j] = arr[j+2];
					}
					arr[size-1] = '!';
					arr[size-2] = '!';
				}
			}
		}

		int sizeNew = 0;
		for(int i=0;i<size;i++){
			if(arr[i] == '!' && sizeNew == 0){
				sizeNew = i;
			}
		}
		
		char[] arrNew = new char[sizeNew];
		
		for(int i=0;i<sizeNew;i++){
			arrNew[i] =arr[i];
		}

		System.out.println(new String(arrNew));

	}
	
	void runLength(){
		String str = "aaabccdde";
		
		int i=0, j=1, count =1;
		int size = str.length();
		char[] arr = new char[size];
		while(i<size -1){
			if(str.charAt(i) == str.charAt(j)){
				count ++;
				j++;
			}
			else if(j == size -1 || str.charAt(i) != str.charAt(j)){
				//Set Count in Array :
				int digits = getNumDigits(count);
				int m = digits, d = i+1, num = count;
				while(m >= 0){
					arr[d] = (char) (num % (10^m -1));
					num = num - arr[d] * (10^m -1);
					d++;
					m--;
				}
				//Left Shift the Whole Array
				for(int k = d+1;k<size-1;k++){
					arr[k] = arr[k+1];
				}
				i = j;
				j = i+1;
				count = 1;
				
			}
		}
	}

	private int getNumDigits(int count) {
		// TODO Auto-generated method stub
		
		return 0;
	}
}

