package net.scharitzer;

import java.io.InputStream;
import java.io.PrintStream;

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
    }
}