package com.java.utils;

public class PointInTriangle {
	
	public static float getArea(int x1, int y1,int x2, int y2,int x3, int y3){
		return (Math.abs(x1*(y2-y3) + x2 *(y3 -y1) + x3*(y1-y2))/2.0f);
	}
	
	public static boolean pointInside(){
		
		/*int p1=10 ;
		int q1=15;
		*/
		int p1=30 ;
		int q1=15;
		int x1 = 0,x2 =0,x3=20,y1=0,y2=10,y3=30;
		
		float orgArea = getArea(x1,y1, x2,y2,x3,y3);
		float areaOne = getArea(x1, y1,x2,y2,p1,q1);
		float areaTwo = getArea(x1, y1,x3,y3,p1,q1);
		float areaThree = getArea(x2,y2,x3,y3,p1,q1);
		
		return orgArea == (areaOne + areaTwo + areaThree);
		
	}
	
	public static void main(String args[]){
		System.out.println(pointInside());
	}

}
