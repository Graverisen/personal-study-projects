package com.in28minutes.junit.helper;



import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringHelperTest 
{
	
	StringHelper helper = new StringHelper();
	//roda antes de tudo
	@BeforeClass
	public static void setupTestes()
	{
		
		System.out.println("ESTOU FAZENDO O SETUP GERAL");
	}
	
	//roda depois de tudo
	@AfterClass
	public static void fechaTestes()
	{
		System.out.println("ESTOU FECHANDO GERAL");
	}

	
	//roda antes de cada teste
	@Before
	public void setupTeste()
	{
		System.out.println("ESTOU FAZENDO O SETUP");
	}
	
	//roda depois de cada teste
	@After
	public void fechaTeste()
	{
		System.out.println("ESTOU FECHANDO O TESTE");
	}
	
	
	@Test
	public void testtruncateAInFirst2Positions1() 
	{
		//AACD -> CD CDAA->CDAA ACD->CD
		assertEquals("CD",helper.truncateAInFirst2Positions("AACD"));
		assertEquals("CDAA",helper.truncateAInFirst2Positions("CDAA"));

	}
	
	@Test
	public void testtruncateAInFirst2Positions2() 
	{
		
		//AACD -> CD CDAA->CDAA ACD->CD
		
		assertEquals("CD",helper.truncateAInFirst2Positions("ACD"));
	}
	
	@Test
	public void testareFirstAndLastTwoCharactersTheSame_BasicNegative() 
	{		
		//ABCD->false ABAB->true AB->true A->false
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}

	
	@Test
	public void testeArraysCompare() 
	{		
		int[] numbers = {1,2,3,4};
		int[] expected = {1,2,3,4};
		
		assertArrayEquals(expected, numbers);
	}
	
	@Test(expected=NullPointerException.class)
	public void arraysExceptionTest() 
	{		
		int[] numbers = null;
		
		
		Arrays.sort(numbers);	
		
	}
	
	@Test(timeout=100)
	public void testeArraysPerformance() 
	{		
		int[] numbers = {56,2,52,11};
		for (int i=0;i<=1000000;i++)
		{
			numbers[0]=i;
			Arrays.sort(numbers);
		}
	}
	
}
