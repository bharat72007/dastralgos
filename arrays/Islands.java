package com.java.arrays;

public class Islands{
	private int[][] island;
	int x = 0;
	int y = 0;
	private boolean[][] isVisited;
	public Islands(int[][] island){
		
		this.x = island.length;
		this.y = island[0].length;	
		this.island = island;
		if(x <1 || y <1){
			throw new IllegalStateException("Not a Legal State");
		}
		this.isVisited = new boolean[x][y];
	}
	
	public int getNumbers(){
		int count = 0;
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				if(1 == island[i][j] && !isVisited[i][j]){
					//isVisited[i][j] = true;
					travel(i,j);
					count = count + 1;
				}
			}
		}
		return count;
	}
		
	public void travel(int i, int j){
		if(i<0 || j <0 ||i==x ||j==y){
			return;
		}
		else{
			if(island[i][j] ==1 && !isVisited[i][j]){
				isVisited[i][j] = true;
				travel(i+1,j); travel(i+1,j+1);
				travel(i+1,j-1); travel(i-1,j);
				travel(i-1,j+1); travel(i-1,j-1);
				travel(i,j+1); travel(i,j-1);
			}	
		}
	}

	public static void main(String args[]){
		int[][] map = { 
			   {1,0,1,1},
			   {1,0,0,1},
			   {1,1,0,1},
			   {1,0,0,1},
			   {1,1,0,1}
			};
		Islands isl = new Islands(map);
		System.out.println(isl.getNumbers());
	}
}