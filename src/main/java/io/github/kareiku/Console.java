package io.github.kareiku;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Console implements IConsole {
    private final Object readLock;
    private final Object writeLock;
    private final Scanner scanner;
    private final PrintStream out;

    public Console(@NotNull InputStream in, @NotNull PrintStream out) {
        this.readLock = new Object();
        this.writeLock = new Object();
        this.scanner = new Scanner(in);
        this.out = out;
    }

    @Override
    public @NotNull String readLine(@NotNull String fmt, @NotNull Object @Nullable ... args) {
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

    @Override
    public void printf(@NotNull String fmt, @NotNull Object @Nullable ... args) {
        this.out.printf(fmt, args);
    }
}
