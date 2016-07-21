package com.java.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineProps {
	
	
	private static class Point{
		private double x;
		private double y;
		
		public Point(double x, double y){
			this.x =x;
			this.y = y;
		}
		
		public double getX(){
			return this.x;
		}
		
		public double getY(){
			return this.y;
		}
	}
	
	private static class Line{
		private Point p1;
		private Point p2;
		public Line(Point p1, Point p2){
			this.p1 = p1;
			this.p2 = p2;
		}
		
		public Point getPointP1(){
			return this.p1;
		}
		
		public Point getPointP2(){
			return this.p2;
		}
	}
	
	
	public static double getDistance(Point p1, Point p2){
		return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
	}
	
	public static double getSlopeOfLine(Line L){
		double m = 0;
		double x1 = L.getPointP1().getX();
		double x2 = L.getPointP2().getX();
		double y1 = L.getPointP1().getY();
		double y2 = L.getPointP2().getY();
		
		if(x1 == x2){
			//Slope is infinite
			m = Double.MAX_VALUE;
		}else{
			m = (y2 - y1)/(x2 - x1);
		}
		
		return m == 0 ? m*-1.0 : m;
	}
	
	public static double getAngleBetweenLines(Line L1, Line L2){
		double m1 = getSlopeOfLine(L1);
		double m2 = getSlopeOfLine(L2);
		
		
		if(m1 == Double.MAX_VALUE){
			return Math.toDegrees(Math.atan(1/m2));
		}
		if(m2 == Double.MAX_VALUE){
			return Math.toDegrees(Math.atan(1/m1));
		}
		
		if(m1 == 0){
			return Math.toDegrees(Math.atan(m2));
		}
		
		if(m2 == 0){
			return Math.toDegrees(Math.atan(m1));
		}
		
		return Math.toDegrees(Math.atan(Math.abs((m1 - m2)/(1 + m1*m2))));
	}
	
	public static Point LineIntersectionPoint(Line L1, Line L2) throws Exception{
		if(0 == getAngleBetweenLines(L1,L2)){
			throw new Exception("Lines cannot Intersect");
		}
		
		/*Line Equation : y -y1 = m1(x -x1)
		 *                y -y3 = m2(x -x3)
		 *                y1 + m1(x-x1) = m2(x-x3) + y3
		 *                (m1-m2)*x = y3 + m1*x1 -m2*x3 -y1 
		 *                y = m1*(x - x1) +y1
		 */
		
		double m1 = getSlopeOfLine(L1);
		double m2 = getSlopeOfLine(L2);
		
		double x1 = L1.getPointP1().getX();
		double y1 = L1.getPointP1().getY();
		double x3 = L2.getPointP1().getX();
		double y3 = L2.getPointP1().getY();
		double x = (y3 + m1 * x1 - m2 *x3 - y1) /(m1 -m2);
		double y = m1*(x -x1) + y1;
		
		Point p = new Point(x,y);
		
		return p;
	}
	
	
	public static boolean isCollinear(Line L1, Line L2){
		//To find If two lines are collinear, make use of concept for 3 points there area of triangle is 0
		double area1 = 0.5 * (L1.p1.x*(L1.p2.y - L2.p1.y) +
				              L1.p2.x*(L2.p1.y - L1.p1.y ) + 
				              L2.p1.x*(L1.p1.y - L1.p2.y));
		
		double area2 = 0.5 * (L1.p1.x*(L1.p2.y - L2.p2.y) +
	              		      L1.p2.x*(L2.p2.y - L1.p1.y ) + 
	                          L2.p2.x*(L1.p1.y - L1.p2.y));
		return area1 == 0.0 && area2 == 0.0;
	}
	
	/*
	 * Find overlapping region in collinear lines
	 */
	public static double overlappingRegionForCollinearLines(Line L1, Line L2) throws Exception{

		double m = getSlopeOfLine(L1);
		if(m == Double.MAX_VALUE){
			//Chain Of line in vertical direction.
			Line topLine = null,bottomLine = null;
			double minY1 = Math.min(L1.p1.y, L1.p2.y);
			double minY2 = Math.min(L2.p1.y, L2.p2.y);
			if(minY1 > minY2){
				topLine = L1;
				bottomLine = L2;
			}
			else{
				topLine = L2;
				bottomLine = L1;
			}
			
			Point tup, tlp,bup,blp;
			//t: top, b: bottom, u: upper, l: lower, p: point ex: tlp : topline upper point
			
			
			if(topLine.p1.y > topLine.p2.y){
				tup = topLine.p1;
				tlp = topLine.p2;
			}
			else{
				tup = topLine.p2;
				tlp = topLine.p1;
				
			}
			if(bottomLine.p1.y > bottomLine.p2.y){
				bup = bottomLine.p1;
				blp = bottomLine.p2;
			}
			else{
				bup = bottomLine.p2;
				blp = bottomLine.p1;
			}
			
			if(tlp.y - bup.y > 0.0){
				return getDistance(tlp,bup);
			}
			else if(tlp.y - bup.y == 0.0){
				return 0.0;
			}
			else{
				throw new Exception("No Overlap");
			}
		}
		else{
			//Chain Of line in Horizontal direction.
			Line leftLine = null,rightLine = null;
			double minX1 = Math.min(L1.p1.x, L1.p2.x);
			double minX2 = Math.min(L2.p1.x, L2.p2.x);
			if(minX1 <= minX2){
				leftLine = L1;
				rightLine = L2;
			}
			else{
				leftLine = L2;
				rightLine = L1;
			}
			
			Point llp, lrp,rlp,rrp;
			//l: left, r: right,  p: point ex: llp : leftline left point
			
			
			if(leftLine.p1.x > leftLine.p2.x){
				lrp = leftLine.p1;
				llp = leftLine.p2;
			}
			else{
				lrp = leftLine.p2;
				llp = leftLine.p1;
			}
			if(rightLine.p1.x > rightLine.p2.x){
				rrp = rightLine.p1;
				rlp = rightLine.p2;
			}
			else{
				rrp = rightLine.p2;
				rlp = rightLine.p1;
			}
			
			if(lrp.x - rlp.x > 0.0){
				return getDistance(lrp,rlp);
			}
			else if(lrp.x - rlp.x == 0.0){
				return 0.0;
			}
			else{
				throw new Exception("No Overlap");
			}
		}
	}
	
	public static boolean isLineSegmentIntersecting(Line L1, Line L2) throws Exception{
		double d1  = getDistance(L1.getPointP1(),L1.getPointP2());
		double d2  = getDistance(L2.getPointP1(),L2.getPointP2());
		//Check for Collinear condition.
		if(isCollinear(L1, L2)){
			if(overlappingRegionForCollinearLines(L1,L2)!= 0.0){
				return true;
			}
			return false;
		}
		try{
			Point p = LineIntersectionPoint(L1, L2);
			double d11 = getDistance(L1.getPointP1(),p);
			double d12 = getDistance(L1.getPointP2(),p);
			double d21 = getDistance(L2.getPointP1(),p);
			double d22 = getDistance(L2.getPointP2(),p);
			return (d1 == (d11 + d12) && d2 == (d21 + d22));
			
		}catch(Exception e){
			return false;
		}
	}
	
	public static void main(String args[]) throws Exception{
		Point p1 = new Point(1,0);
		Point p2 = new Point(5,0);
		Point p3 = new Point(8,0);
		Point p4 = new Point(10,0);
		Line L1 = new Line(p1,p2);
		Line L2 = new Line(p3,p4);
		System.out.println(overlappingRegionForCollinearLines(L1,L2));
		//System.out.println(isCollinear(L1,L2));
		//System.out.println(isLineSegmentIntersecting(L1,L2));
		//System.out.println(getAngleBetweenLines(L1,L2));
		//Point p = LineIntersectionPoint(L1,L2);
		//System.out.println(p.x + ";" + p.y);
	}
}
