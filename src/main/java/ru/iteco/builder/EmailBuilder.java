package ru.iteco.builder;

import ru.iteco.builder.api.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static ru.iteco.builder.Mail.*;

public class EmailBuilder {

    public static FromBuilder subject(String subject) {
        return new FromBuilderImpl(subject);
    }

    private static class FromBuilderImpl implements FromBuilder {

        private final String subject;
        private String from;
        private final Set<String> to = new HashSet<>();

        private FromBuilderImpl(String subject) {
            this.subject = subject;
        }

        @Override
        public FromBuilder from(String from) {
            this.from = from;
            return this;
        }

        @Override
        public ToBuilder to(String to) {
            this.to.add(to);
            return new ToBuilderImpl();
        }

        @Override
        public ToBuilder toAll(Collection<String> toAll) {
            this.to.addAll(toAll);
            return new ToBuilderImpl();
        }

        private class ToBuilderImpl extends CopyBuilderImpl implements ToBuilder {

            {
                from = from == null ? "default" : from;
            }

            @Override
            public ToBuilder to(String to) {
                FromBuilderImpl.this.to.add(to);
                return this;
            }

            @Override
            public ToBuilder toAll(Collection<String> toAll) {
                FromBuilderImpl.this.to.addAll(toAll);
                return this;
            }
        }

        private class CopyBuilderImpl implements CopyBuilder {

            private final Set<String> copyTo = new HashSet<>();
            private Content content;

            @Override
            public CopyBuilder copyTo(String copyTo) {
                this.copyTo.add(copyTo);
                return this;
            }

            @Override
            public CopyBuilder copyToAll(Collection<String> copyToAll) {
                this.copyTo.addAll(copyToAll);
                return this;
            }

            @Override
            public FinallyBuilder content(String body) {
                this.content = new Content(body, null);
                return new FinallyBuilderImpl();
            }

            @Override
            public FinallyBuilder content(String body, String signature) {
                this.content = new Content(body, signature);
                return new FinallyBuilderImpl();
            }

            private class FinallyBuilderImpl implements FinallyBuilder {

                @Override
                public Mail build() {
                    return new Mail(subject, from, to, copyTo, content);
                }
            }
        }
    }
}