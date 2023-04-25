package Junit;

import org.junit.Test;

public class JunitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Test
	public void testSetup() {
		String str = "I am done with Junit setup.";
		assertEquals("I am done with Junit setup.",str);
	}

}
