package ru.iteco.builder;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EmailBuilderTest {

    @Test
    public void test() {
        final Mail mail = EmailBuilder.subject("test-subject")
                .from("test-from")
                .to("test-to")
                .copyTo("test-copyTo")
                .content("test-body", "test-signature")
                .build();

        System.out.println(mail);
    }

    @Test
    public void testWithoutFrom() {
        final Mail mail = EmailBuilder.subject("test-subject")
                .to("test-to1")
                .to("test-to2")
                .toAll(Arrays.asList("test-to1", "test-to3"))
                .copyTo("test-copyTo")
                .content("test-body", "test-signature")
                .build();

        System.out.println(mail);
    }

}