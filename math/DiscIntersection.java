package com.java.utils;

public class DiscIntersection {
	
	public static int Intersections(int[] a){
	    int result = 0;
	    int[] dps = new int[a.length];
	    int[] dpe = new int[a.length];

	    for (int i = 0; i < a.length; i++)
	    {
	        dps[Math.max(0, i - a[i])]++;
	        dpe[Math.min(a.length - 1, i + a[i])]++;
	    }
	    
	    for(int i=0;i<a.length;i++){
	    	System.out.print(dps[i] + ";");
	    }
	    System.out.println();
	    for(int i=0;i<a.length;i++){
	    	System.out.print(dpe[i]+ ";");
	    }

	    int t = 0;
	    for (int i = 0; i < a.length; i++)
	    {
	        if (dps[i] > 0)
	        {
	            result += t * dps[i];
	            result += dps[i] * (dps[i] - 1) / 2;
	            t += dps[i];
	        }
	        t -= dpe[i];
	    }

	    return result;
	}
	
	public static void main(String args[]){
		int A[] = new int[6];
		A[0]=1;A[1]=5;A[2]=2;A[3]=1;A[4]=4;A[5]=0;
		System.out.println(Intersections(A));
	}

}
