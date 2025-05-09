package io.github.kareiku;

import org.jetbrains.annotations.NotNull;

public interface IConsole {
    @NotNull String read();

    void print(@NotNull Object... args);

    void println(@NotNull Object... args);

    void error(@NotNull Object... args);
}
