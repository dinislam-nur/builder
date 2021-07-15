package ru.iteco.builder.api;

public interface ContentBuilder {
    FinallyBuilder content(String body);
    FinallyBuilder content(String body, String signature);
}
