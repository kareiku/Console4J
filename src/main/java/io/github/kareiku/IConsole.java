package io.github.kareiku;

public interface IConsole {
    void printf(String fmt, Object... args);

    String readLine(String fmt, Object... args);
}
