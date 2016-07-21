package com.java.arrays;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Refactor the Code Later On
 */

public class WordsFind {

	private static char[][] mat = {
			{'R','E','S','T'},
			{'R','M','O','O'},
			{'O','E','P','S'},
			{'K','A','L','S'},
			{'R','E','S','P'}
	}; 

	private static HashSet<String> dict = new HashSet<String>();

	private static void setUp(){
		dict.add("ARM");
		dict.add("MEAL");
		dict.add("SOP");
		dict.add("MEALS");
		dict.add("ALPS");
		dict.add("REST");
	}					

	private static void wordsPrint(){
		int m =mat.length, n=mat[0].length;
		Queue<Tuple> queue = new LinkedList<Tuple>();
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				queue.add(new Tuple(i,j,String.valueOf(mat[i][j])));
				
			}
		}
		
		Tuple front = null;
		while(!queue.isEmpty()){
			front = queue.peek();
			queue.remove();

			/*
			 *	Check for all directions & check the prefixes
			 */
            int i = front.getI();
            int j = front.getJ();
            
			if((i+1 <m)  && isWordExists(front.getString() + mat[i+1][j]))		printChar(front.getString() +  mat[i+1][j]);
			if((j+1 < n) && isWordExists(front.getString() +  mat[i][j+1]))		printChar(front.getString() +  mat[i][j+1]);
			if((i-1 > -1) && isWordExists(front.getString() +  mat[i-1][j]))	printChar(front.getString() +  mat[i-1][j]);
			if((j-1> -1) && isWordExists(front.getString() +  mat[i][j-1]))		printChar(front.getString() +  mat[i][j-1]);
			

			/*
			 * Check for Prefixes
			 */
			if((j+1 < n) && isPrefixExist(front.getString() +  mat[i][j+1]))	queue.add(new Tuple(i,j+1,front.getString() + mat[i][j+1]));
			if((i-1 > -1) && isPrefixExist(front.getString()+ mat[i-1][j]))		queue.add(new Tuple(i-1,j,front.getString()+ mat[i-1][j]));
			if((j-1> -1) && isPrefixExist(front.getString() +  mat[i][j-1]))	queue.add(new Tuple(i,j-1,front.getString() + mat[i][j-1]));
			if((i+1 <m)  && isPrefixExist(front.getString()+ mat[i+1][j]))		queue.add(new Tuple (i+1,j,front.getString()+ mat[i+1][j]));
			
		}
	}

	private static boolean isWordExists(String word){
		Iterator it = dict.iterator();
		while(it.hasNext()){
			if(word.equals(it.next())){
				return true;
			}
		}
		return  false;
	}

	private static boolean isPrefixExist(String cumStr){
		String prefix = cumStr ;
		Iterator it = dict.iterator();
		while (it.hasNext()) {
			String pair = (String)it.next();
			if(pair.toString().startsWith(prefix)){
				return true;
			}
		}
		return false;
	}
	
	private static void printChar(String ch){
		System.out.println(ch);
	}
	
	

	public static void main(String args[]){
		setUp();
		wordsPrint();
	}
	
	
}
