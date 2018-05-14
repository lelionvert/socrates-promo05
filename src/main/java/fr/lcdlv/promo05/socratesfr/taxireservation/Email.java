package fr.lcdlv.promo05.socratesfr.taxireservation;

import java.util.Objects;

public class Email {
    private final String to;
    private final String subject;
    private final String content;

    public Email(String to, String subject, String content) {

        this.to = to;
        this.subject = subject;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Email{" +
                "to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(to, email.to) &&
                Objects.equals(subject, email.subject) &&
                Objects.equals(content, email.content);
    }

    @Override
    public int hashCode() {

        return Objects.hash(to, subject, content);
    }
}
