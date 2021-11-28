package pl.glownia.pamela.chatsimulator;

class ChatMessage {
    private final String sender;
    private final String receiver;
    private final int amountOfVirtualCoins;
    private byte[] signature;
    private int identifier;

    ChatMessage(String sender, int amountOfVirtualCoins, int identifier, String receiver) {
        this.sender = sender;
        this.amountOfVirtualCoins = amountOfVirtualCoins;
        this.identifier = identifier;
        this.receiver = receiver;
    }

    void setSignature(byte[] signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return sender + " sent " + amountOfVirtualCoins + " Virtual Coins to " + receiver;
    }
}