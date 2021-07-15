package ru.iteco.builder;

import java.util.Set;

public class Mail {

    private final String subject;
    private final String from;
    private final Set<String> to;
    private final Set<String> copyTo;
    private final Content content;

    public Mail(String subject, String from, Set<String> to, Set<String> copyTo, Content content) {
        this.subject = subject;
        this.from = from;
        this.to = to;
        this.copyTo = copyTo;
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public String getFrom() {
        return from;
    }

    public Set<String> getTo() {
        return to;
    }

    public Set<String> getCopyTo() {
        return copyTo;
    }

    public Content getContent() {
        return content;
    }

    public static class Content {

        private final String body;
        private final String signature;

        public Content(String body, String signature) {
            this.body = body;
            this.signature = signature;
        }

        public String getBody() {
            return body;
        }

        public String getSignature() {
            return signature;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "body='" + body + '\'' +
                    ", signature='" + signature + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Mail{" +
                "subject='" + subject + '\'' +
                ", from='" + from + '\'' +
                ", to=" + to +
                ", copyTo=" + copyTo +
                ", content=" + content +
                '}';
    }
}
