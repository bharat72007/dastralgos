package com.java.strings;

import org.junit.Test;

public class TestKP {

	@Test
	public void test() {
		long startTime = System.nanoTime();
		System.out.println(KP.kp(0, "xabx".length()-1, 1, "xabx"));
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
		
	}

}
