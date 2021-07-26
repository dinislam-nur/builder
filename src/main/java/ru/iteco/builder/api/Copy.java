package ru.iteco.builder.api;

import java.util.Collection;

public interface Copy {
    CopyBuilder copyTo(String copyTo);
    CopyBuilder copyToAll(Collection<String> copyToAll);
}
