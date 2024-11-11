package net.scharitzer;

import java.io.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main implements Runnable {

    private InputStream stdin = System.in;
    private PrintStream stdout = System.out;
    private Exception exception = null;

    public static void main(String[] args) {
        Main instance = new Main();
        instance.run();

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }

    public void run() {
        stdout.println("run");
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
    }
}