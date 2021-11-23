package pl.glownia.pamela;

public class ChatMessage {
    public ChatMessage(String user, String message) {
        this.user = user;
        this.message = message;
    }

    private final String user;
    private final String message;

    @Override
    public String toString() {
        return user + ": " + message;
    }
}
