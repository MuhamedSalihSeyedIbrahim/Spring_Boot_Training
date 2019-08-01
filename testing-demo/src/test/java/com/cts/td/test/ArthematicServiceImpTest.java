package com.cts.td.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cts.td.service.ArthematicServiceImp;

public class ArthematicServiceImpTest {

	@Test
	public void testAdd() {
		
		ArthematicServiceImp a= new ArthematicServiceImp();
		int actual=a.add(5,5);
		int expected= 52;
		assertEquals(expected, actual);
	}

}
