package com.in28minutes.junit.helper;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperParametrizedTest {

	private String input;
	private String output;
	
	public StringHelperParametrizedTest(String input, String output) {
		super();
		this.input = input;
		this.output = output;
	}

	StringHelper helper = new StringHelper();
	
	@Parameters
	public static Collection testeConditions()
	{
		//input/output
		String expectedOutputs[][] = {{"AACD","CD"},{"ACD","CD"}};
		return Arrays.asList(expectedOutputs);
	}
	
	
	@Test
	public void testtruncateAInFirst2Positions1() 
	{
		//AACD -> CD CDAA->CDAA ACD->CD
		assertEquals(output,helper.truncateAInFirst2Positions(input));
	

	}
	
	@Test
	public void testtruncateAInFirst2Positions2() 
	{
		
		//AACD -> CD CDAA->CDAA ACD->CD
		
		assertEquals(output,helper.truncateAInFirst2Positions(input));
	}

}
