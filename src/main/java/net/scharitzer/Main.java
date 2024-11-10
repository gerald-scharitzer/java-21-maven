package net.scharitzer;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main implements Runnable {

    private InputStream stdin = System.in;
    private PrintStream stdout = System.out;

    public static void main(String[] args) {
        Main instance = new Main();
        instance.run();

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }

    public void run() {
        stdout.println("run");
        BufferedInputStream bis = new BufferedInputStream(stdin);
        ReadableByteChannel rbc = Channels.newChannel(bis);
        Reader inReader = Channels.newReader(rbc, Charset.defaultCharset());
    }
}