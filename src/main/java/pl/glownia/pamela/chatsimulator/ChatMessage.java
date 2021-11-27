package pl.glownia.pamela.chatsimulator;

class ChatMessage {
    private final String user;
    private final String text;
    private byte[] signature;
    private int identifier;

    ChatMessage(String user, String text, int identifier) {
        this.user = user;
        this.text = text;
        this.identifier = identifier;
    }

    void setSignature(byte[] signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return user + ": " + text;
    }
}