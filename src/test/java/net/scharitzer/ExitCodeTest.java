package net.scharitzer;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ExitCodeTest {

	@Test
	public void testValues() {
		assertEquals(ExitCode.SUCCESS.value(), 0);
		assertEquals(ExitCode.FAILURE.value(), 1);
	}

}
