package com.java.strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEncodeString {

	@Test
	public void test() {
		EncodedString.getOrgString("kittens%20.jpg");
		EncodedString.getOrgString("kittens%20");
		EncodedString.getOrgString("%20kittens%20");
	}

}
