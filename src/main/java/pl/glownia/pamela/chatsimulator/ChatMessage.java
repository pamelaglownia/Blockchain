package pl.glownia.pamela.chatsimulator;

class ChatMessage {
    private final String user;
    private final String text;

    ChatMessage(String user, String text) {
        this.user = user;
        this.text = text;
    }

    @Override
    public String toString() {
        return user + ": " + text;
    }
}