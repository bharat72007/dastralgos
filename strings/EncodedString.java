package com.java.strings;

public class EncodedString {
	
	private static final String spaceEncode = "%20";

	public static String getOrgString(String encStr){
		int size = encStr.length();
		for(int i=0; i<size; i++){
			if(i+2<size){
				System.out.println(getEncString(encStr, i));
				
			}
		}
		
		return null;
	}

	private static String getEncString(String encStr, int index) {
		// TODO Auto-generated method stub
		System.out.println();
		if(encStr.charAt(index) == spaceEncode.charAt(0) && 
				encStr.charAt(index+1) == spaceEncode.charAt(1) &&
				encStr.charAt(index+2) == spaceEncode.charAt(2) ){
			return encStr.substring(0,index) + " " + encStr.substring(index+3);
		}
		return encStr;
	}

	
	
}
