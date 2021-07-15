package ru.iteco.builder.api;

import java.util.Collection;

public interface CopyBuilder {
    CopyBuilder copyTo(String copyTo);
    CopyBuilder copyToAll(Collection<String> copyToAll);
    FinallyBuilder content(String body);
    FinallyBuilder content(String body, String signature);
}