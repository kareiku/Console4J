package io.github.kareiku;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Console implements IConsole {
    private final Object readLock;
    private final Object writeLock;
    private final Scanner scanner;
    private final PrintStream out;

    public Console(InputStream in, PrintStream out) {
        this.readLock = new Object();
        this.writeLock = new Object();
        this.scanner = new Scanner(in);
        this.out = out;
    }

    @Override
    public void printf(String fmt, Object... args) {
        this.out.printf(fmt, args);
    }

    @Override
    public String scanf(String fmt, Object... args) {
        String line;
        synchronized (this.writeLock) {
            synchronized (this.readLock) {
                if (!fmt.isEmpty()) {
                    this.out.printf(fmt, args);
                }
                line = this.scanner.nextLine();
            }
        }
        return line;
    }
}
