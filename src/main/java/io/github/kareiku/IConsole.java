package io.github.kareiku;

import org.jetbrains.annotations.NotNull;

public interface IConsole {
    @NotNull String readLine(@NotNull String fmt, @NotNull Object... args);

    void printf(@NotNull String fmt, @NotNull Object... args);
}
