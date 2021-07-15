package ru.iteco.builder.api;

import java.util.Collection;

public interface FromBuilder {
    FromBuilder from(String from);
    ToBuilder to(String to);
    ToBuilder toAll(Collection<String> toAll);
}
