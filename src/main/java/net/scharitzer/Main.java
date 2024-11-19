package net.scharitzer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main implements Runnable {

	private String[] args;
	private InputStream stdin = System.in;
	private PrintStream stdout = System.out;
	private int exitCode = ExitCode.FAILURE.value();
	private Exception exception = null;

	public Main(String[] args) { this.args = args; }

	public static void main(String[] args) {
		Main instance = new Main(args);
		instance.run();
		if (instance.exception != null) {
			instance.exception.printStackTrace();
		}
		System.exit(instance.exitCode);
	}

	public void run() {
		stdout.println("argc " + args.length);
		// FIXME Config config = Config.fromYaml(stdin);
		ReadableByteChannel rbc = Channels.newChannel(stdin);
		Reader reader = Channels.newReader(rbc, Charset.defaultCharset());
		BufferedReader bufRead = new BufferedReader(reader);
		String line;
		try {
			while ((line = bufRead.readLine()) != null) {
				stdout.println(line);
			}
		} catch (IOException e) {
			exception = e;
			return;
		}
		exitCode = ExitCode.SUCCESS.value();
	}
}