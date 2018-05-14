package fr.lcdlv.promo05.socratesfr.taxireservation;

public class Email {
    private final String to;
    private final String subject;
    private final String content;

    public Email(String to, String subject, String content) {

        this.to = to;
        this.subject = subject;
        this.content = content;
    }
}
