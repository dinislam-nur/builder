package ru.iteco.builder.api;

import java.util.Collection;

public interface ToBuilder {
    ToBuilder to(String to);
    ToBuilder toAll(Collection<String> toAll);
    CopyBuilder copyTo(String copyTo);
    CopyBuilder copyToAll(Collection<String> copyToAll);
}