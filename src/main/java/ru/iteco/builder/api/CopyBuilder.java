package ru.iteco.builder.api;

public interface CopyBuilder extends Copy{
    FinallyBuilder content(String body);
    FinallyBuilder content(String body, String signature);
}