package org.cap.bankapp.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
@RunWith(Parameterized.class)
public class ParameterizedTestCase {
	private int input1;
	private int input2;
	private int output;
	
	public ParameterizedTestCase(int input1, int input2, int output)
	{
		this.input1=input1;
		this.input2=input2;
		this.output=output;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
