package ru.iteco.builder.api;

import java.util.Collection;

public interface To {
    ToBuilder to(String to);
    ToBuilder toAll(Collection<String> toAll);
}
