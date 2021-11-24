package pl.glownia.pamela.chatsimulator;

 class ChatMessage {
     ChatMessage(String user, String message) {
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