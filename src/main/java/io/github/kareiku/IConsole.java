package io.github.kareiku;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IConsole {
    @NotNull String readLine(@NotNull String fmt, @NotNull Object @Nullable ... args);

    void printf(@NotNull String fmt, @NotNull Object @Nullable ... args);
}
