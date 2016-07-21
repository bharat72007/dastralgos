package com.java.strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLongestChain {

	@Test
	public void testV1() {

		int[][]matrix = {{2,5,1},
						 {7,8,4},
						 {6,9,3}};
		LongestChain lc = new LongestChain(3,matrix);
		assertEquals(4,lc.getLongestChain());
		
	}
	
	@Test
	public void testV2() {

		int[][]matrix = {{7,8,9},
						 {6,1,2},
						 {5,4,3}};
		LongestChain lc = new LongestChain(3,matrix);
		assertEquals(9,lc.getLongestChain());
		
	}
	
	@Test
	public void testV3() {

		int[][]matrix = {{2,4,6},
						 {5,9,3},
						 {7,1,8}};
		LongestChain lc = new LongestChain(3,matrix);
		assertEquals(0,lc.getLongestChain());
		
	}
	
	@Test
	public void testV4() {

		int[][]matrix = {{1}};
		LongestChain lc = new LongestChain(1,matrix);
		assertEquals(1,lc.getLongestChain());
		
	}

}
