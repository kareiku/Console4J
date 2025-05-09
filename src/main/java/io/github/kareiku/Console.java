package io.github.kareiku;

import org.jetbrains.annotations.NotNull;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Console implements IConsole {
    private final Scanner scanner;
    private final PrintStream stdout;
    private final PrintStream stderr;

    public Console() {
        this(new Scanner(System.in), System.out, System.err);
    }

    public Console(@NotNull Scanner scanner, @NotNull PrintStream stdout, @NotNull PrintStream stderr) {
        this.scanner = scanner;
        this.stdout = stdout;
        this.stderr = stderr;
    }

    @Override
    public @NotNull String read() {
        return this.scanner.nextLine();
    }

    @Override
    public void print(@NotNull Object... args) {
        this.stdout.print(this.format(args));
    }

    @Override
    public void println(@NotNull Object... args) {
        this.stdout.println(this.format(args));
    }

    @Override
    public void error(@NotNull Object... args) {
        this.stderr.println(this.format(args));
    }

    private String format(@NotNull Object obj) {
        return obj.getClass().cast(obj).toString();
    }

    private String format(@NotNull Object[] objects) {
        return Arrays.stream(objects).map(this::format).collect(Collectors.joining());
    }
}
