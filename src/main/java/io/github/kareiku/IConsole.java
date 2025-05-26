package io.github.kareiku;

public interface IConsole {
    void printf(String fmt, Object... args);

    String scanf(String fmt, Object... args);
}
