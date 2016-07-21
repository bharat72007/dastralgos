package com.java.strings;

public class KP {
	
	public static boolean kp(int i, int j , int k , String str){
		if(k == 0){
			return false;
		}
		else if(i>j){
			return false;
		}
		else if(("").equals(str)){
			return false;
		}
		else{
			String strNew = "";
			if(j == str.length()-1){
				strNew = str.substring(0,j);
				System.out.println(strNew);
			}
			else{
				strNew = str.substring(0,j)+str.substring(j+1,str.length());
			}
			return kp(i+1,j-1,k,str) || isPal(str) || kp(i,j,k-1,str.substring(0,i)+str.substring(i+1,str.length())) || isPal(str.substring(0,i)+str.substring(i+1,str.length())) ||
				kp(i,j,k-1,strNew) || isPal(strNew) ;
		}
	}

	private static boolean isPal(String str){
		System.out.print(str  + " : ");
		int i=0, j = str.length()-1;
		while(i<=j){
			if(str.charAt(i)==str.charAt(j)){
				i++;
				j--;
			}
			else{
				System.out.println(false);
				return false;
			}
		}
		System.out.println(true);
		return true;
	}


}
