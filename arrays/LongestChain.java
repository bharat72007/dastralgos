package com.java.strings;

public class LongestChain {
	private int dim;
	private int[][] matrix;

	//Expecting dim>1
	public LongestChain(int dim, int[][]M){
		this.dim = dim;
		this.matrix = M;
	}

	public int getLongestChain(){
		if(this.dim == 1){
			return 1;
		}
		int maxlengthChain = 0;
		int currentLength = 0;

		for(int i=0;i<dim;i++){
			for(int j=0;j<dim;j++){
				currentLength = getLongestChain(new boolean[dim][dim],i,j);
				maxlengthChain = maxlengthChain > currentLength ?maxlengthChain : currentLength; 
			}
		}
		//	System.out.println(maxlengthChain);
		return maxlengthChain;
	}

	public int getLongestChain(boolean [][]V,int X, int Y){
		//Avoid Hitting the Walls
		if(X >= 0 && X<dim && Y >= 0 && Y< dim){
			//Not be an Visited Cell.
			if(!V[X][Y]){
				V[X][Y] = true;
				int p1=0,p2=0,p3=0,p4=0;
				if(validate(X,Y,X,Y+1)){
					p1 = getLongestChain(V, X, Y+1) + 1;
				}
				if(validate(X,Y,X,Y-1)){
					p2 = getLongestChain(V, X, Y-1) + 1;
				}
				if(validate(X,Y,X+1,Y)){
					p3 = getLongestChain(V, X+1, Y) + 1;
				}
				if(validate(X,Y,X-1,Y)){
					p4 = getLongestChain(V, X-1, Y) + 1;
				}
				return max(p1,p2,p3,p4);
			}
		}

		return 0;
	}	


	private boolean validate(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
		if(x2 >= 0 && x2<dim && y2 >= 0 && y2< dim){
			return (matrix[x1][y1] - matrix[x2][y2] == 1 || matrix[x1][y1] - matrix[x2][y2] == -1);
		}
		return  false;
	}

	private static int max(int a, int b, int c, int d) {
		// TODO Auto-generated method stub
		int x = a>b ? a:b;
		int y = c >d ?c :d;
		int maxVal = x >y ? x :y;
		return maxVal;
	}
}
