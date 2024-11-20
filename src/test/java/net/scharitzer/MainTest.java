package net.scharitzer;

import java.io.InputStream;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MainTest {

	@Test
	public void test() {
		Main main = new Main(new String[0]);
		main.setStdin(InputStream.nullInputStream()); // TODO read from string
		main.run();
		assertEquals(main.getExitCode(), ExitCode.SUCCESS.value());
	}
}
