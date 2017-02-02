package PackageTesteLeandro;

import static org.junit.Assert.*;

import org.junit.Test;

public class returnRandomTest {

	@Test
	public void test() {
		//setup
		int howMany = 100;
		//execute
		int result = returnRandom.getRandom(howMany);
		//assert
		int expected = 55;
		assertEquals(expected,result);		
	}
	@Test(expected=IllegalArgumentException.class)
	public void test_char() {
		//setup
		char howMany = 108;
		//execute
		int result = returnRandom.getRandom(howMany);
		
	}

}
