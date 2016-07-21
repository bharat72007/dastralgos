package com.java.strings;

public class RectanglesOverlap {

	public static  boolean isOverlap(Rectangle R1, Rectangle R2){
		int x1 = R1.getX1();
		int y1 = R1.getY1();
		int x2 = R1.getX3();
		int y2 = R1.getY3();
	
		int x3 = R2.getX1();
		int y3 = R2.getY1();
		int x4 = R2.getX3();
		int y4 = R2.getY3();
		
		int [] X = {x1,x2,x3,x4};
		int [] Y=  {y1,y2,y3,y4};
		
		getOverlappedArea(X,Y);
		
		return ((x3 < x2 && x4 > x1)&&(y3 > y2 && y1 > y4));
		
	}
	
	public static int getOverlappedArea(int[]X, int[]Y){
		int maxX = max(X);
		int minX = min(X);
		int maxY = max(Y);
		int minY = min(Y);
		
		
		return 0;
	}
	
	private static int min(int[] x) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static int max(int[] x) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String args[]){
		Rectangle R1 = new Rectangle(10,0,20,0,20,-10,10,-10);
		Rectangle R2 = new Rectangle(15,-5,17,-5,17,-15,15,-15);
		System.out.println(isOverlap(R1,R2));
		Rectangle R3 = new Rectangle(15,1,17,1,17,-15,15,-15);
		System.out.println(isOverlap(R1,R3));
		Rectangle R4 = new Rectangle(17,1,19,1,19,-15,17,-15);
		System.out.println(isOverlap(R3,R4));
	}
	
	
	static class Rectangle{
		private int x1;
		private int x2;
		private int x3;
		private int x4;
		
		private int y1;
		private int y2;
		private int y3;
		private int y4;
		
		public Rectangle(int x1, int x2,int x3, int x4,int y1, int y2,int y3, int y4){
			this.x1 = x1;this.x2 = x2;this.x3 = x3;this.x4 = x4;
			this.y1 = y1;this.y2 = y2;this.y3 = y3;this.y4 = y4;
		}

		public int getX1() {
			return x1;
		}

		public void setX1(int x1) {
			this.x1 = x1;
		}

		public int getX2() {
			return x2;
		}

		public void setX2(int x2) {
			this.x2 = x2;
		}

		public int getX3() {
			return x3;
		}

		public void setX3(int x3) {
			this.x3 = x3;
		}

		public int getX4() {
			return x4;
		}

		public void setX4(int x4) {
			this.x4 = x4;
		}

		public int getY1() {
			return y1;
		}

		public void setY1(int y1) {
			this.y1 = y1;
		}

		public int getY2() {
			return y2;
		}

		public void setY2(int y2) {
			this.y2 = y2;
		}

		public int getY3() {
			return y3;
		}

		public void setY3(int y3) {
			this.y3 = y3;
		}

		public int getY4() {
			return y4;
		}

		public void setY4(int y4) {
			this.y4 = y4;
		}
	}
	

}
